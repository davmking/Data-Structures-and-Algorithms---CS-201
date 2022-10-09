/* Two phrases are anagrams if they are permutations of each other, ignoring spaces and capitalization.
For example, "Aaagmnrs" is an anagram of "anagrams", and "TopCoder" is an anagram of "Drop Cote". 
Given a String[] phrases, remove each phrase that is an anagram of an earlier phrase, and return the remaining phrases in their original order.

In writing code you'll need to return a new array whose elements aren't anagrams of each other. */

import java.util.ArrayList;
import java.util.Arrays;

public class Aaagmnrs {
    public String[] anagrams(String[] phrases) {
       ArrayList<String> unWords = new ArrayList<>();
       for(String phrase : phrases){
        unWords.add(phrase);
       }
       int j = 0;
       ArrayList<String> AnaWords = new ArrayList<>();
       for(String phrase : phrases){
        phrase = phrase.toLowerCase();
        phrase = phrase.replace(" ","");
        char[] letters = phrase.toCharArray();
        Arrays.sort(letters);
        String let = new String(letters);
        if(!AnaWords.contains(let)){
            AnaWords.add(let);
            j++;
        }
        else if(AnaWords.contains(let)){
            unWords.remove(j);
        }
       }
       String[] ans = new String[unWords.size()];
       for(int i = 0; i < unWords.size(); i++){
        ans[i] = unWords.get(i);
       }
       return ans;
    }
 }
