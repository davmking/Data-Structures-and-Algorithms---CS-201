import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.Random;

public class HashMarkov implements MarkovInterface{
    
    protected String[] myWords;
    protected Random myRandom;
    protected int myOrder;
    protected HashMap<WordGram, List<String>> myMap;

    public HashMarkov(){
        this(2);
    }

    public HashMarkov(int order){
        myOrder = order;
        myRandom = new Random();
        myMap = new HashMap<>();
    }

    @Override
	public void setTraining(String text){
        myMap.clear();
		myWords = text.split("\\s+");
        for(int i = 0; i < myWords.length - myOrder; i++){
            WordGram next = new WordGram(myWords, i, myOrder);
            List<String> newWords = new ArrayList<>();
            if(!myMap.containsKey(next)){
                myMap.put(next, newWords);
            }
            List<String> oldWords = myMap.get(next);
            oldWords.add(myWords[i + myOrder]);
            myMap.put(next, oldWords);
            //else{
                //List<String> oldWords = myMap.get(next);
                //for(String word : newWords){
                    //oldWords.add(word);
                //}
                //myMap.put(next, oldWords);
            //}
        }
	}

    @Override
    public List<String> getFollows(WordGram wgram){
        if(myMap.containsKey(wgram)){
            return(myMap.get(wgram));
        }
        else{
            List<String> empty = new ArrayList<>();
            return empty;
        }
    }

    /*private String getNext(WordGram wgram) {
		List<String> follows = getFollows(wgram);
		if (follows.size() == 0) {
			int randomIndex = myRandom.nextInt(myWords.length);
			follows.add(myWords[randomIndex]);
		}
		int randomIndex = myRandom.nextInt(follows.size());
		return follows.get(randomIndex);
	}*/

    @Override
    public String getRandomText(int length){
        List<String> randomWords = new ArrayList<>(length);
		int index = myRandom.nextInt(myWords.length - myOrder + 1);
		WordGram current = new WordGram(myWords,index,myOrder);
        randomWords.add(current.toString());

        for(int i = 0; i < length - myOrder; i+= 1){
            List<String> words = getFollows(current);
            if(words.size() == 0){
                int wordNum = myRandom.nextInt(myWords.length);
                words.add(myWords[wordNum]);
            }
            int wordNum = myRandom.nextInt(words.size());
            String newWord = words.get(wordNum);
            randomWords.add(newWord);
            current = current.shiftAdd(newWord);
        }
		//randomWords.add(current.toString());

        /*for(int k=0; k < length-myOrder; k += 1) {
			String nextWord = getNext(current);
			randomWords.add(nextWord);
			current = current.shiftAdd(nextWord);
		}*/

        return String.join(" ", randomWords);
    }

    @Override
    public int getOrder() {
		return myOrder;
	}

    @Override
	public void setSeed(long seed) {
		myRandom.setSeed(seed);
	}
}
