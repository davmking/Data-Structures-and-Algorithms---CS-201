/*In days of yore, aka BG (Before Google), search engines ranked webpages in part by the number of occurrences of a word on the page.
You should write method most to determine and return the word that occurs most often in an array of sentences. This most frequently
occurring word will be unique --- that is you don't need to worry about two words both occuring more often than any other word.
The word returned should be all lower-case regardless of the case of leters in sentences.

Each string in sentences represents several words, each word is delimited by spaces from other words. Words should be considered the
same without respect to case, so BIG is the same word as big, for example. */

import java.util.Map;
import java.util.TreeMap;

public class BigWord {
    public String most(String[] sentences) {
        Map<String, Integer> countMap = new TreeMap<>();
        for(String sentence : sentences){
            String[] words = sentence.split(" ");
            for(String word : words){
                word = word.toLowerCase();
                if(!countMap.containsKey(word)){
                    countMap.put(word, 1);
                }
                else{
                    int currentVal = countMap.get(word);
                    countMap.put(word, currentVal += 1);
                }
            }
        }
        Integer ansInt = countMap.values().stream().max(Integer::compare).get();
        //Integer ansInt2 = ansInt;
        String ans = "";
        for(String key : countMap.keySet()){
            if(ansInt == countMap.get(key)){
                ans = key;
            }
        }
        return ans;
    }
}
