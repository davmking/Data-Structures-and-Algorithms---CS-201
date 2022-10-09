/*Determine how many unique words in an array of words start with a specified letter.
Write a method that determines how many different strings in words have a first letter equal to first. */

public class Starter {
    public int begins(String[] words, String first) {
        int ans = 0;
        String unWords = "";
        for(int i = 0; i < words.length; i++){
            if(words[i].charAt(0) == (first.charAt(0))){
                if(!unWords.contains(words[i] + ",")){
                    unWords += words[i] + ",";
                    ans++;
                }
            }
        }
        return ans;
    }
}
