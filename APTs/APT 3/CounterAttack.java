/* Count how many times each element of words occurs as a white-space delimited string in parameter str.
Return the number of occurrences in an int[] so that the number of times that words[k] occurs is given by the kth value in the returned array. */

import java.util.TreeMap;
import java.util.Map;

public class CounterAttack {
    public int[] analyze(String str, String[] words) {
        int[] ans = new int[words.length];
        String[] testWords = str.split(" ");
        Map<String, Integer> ansMap = new TreeMap<>();
        for(String word : words){
            ansMap.put(word, 0);
        }
        for(String word : testWords){
            if(ansMap.containsKey(word)){
                int currentVal = ansMap.get(word);
                ansMap.put(word, currentVal += 1);
            }
        }
        for(int j = 0; j < words.length; j++){
            ans[j] = ansMap.get(words[j]);
        }
        return ans;
    }
}
