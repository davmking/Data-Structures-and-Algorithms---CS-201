import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {

    private class Phrase {
        private String myPhrase;
        private int count;
        
        Phrase(String str){
            myPhrase = str;
        }

        Phrase(String str, int num){
            myPhrase = str;
            count = num;
        }

        public String myPhrase(){
            return myPhrase;
        }

        public int count(){
            return count;
        }
     }

    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> allPhrases = new ArrayList<>();
        HashSet<String> unPhrases = new HashSet<>();
        for(String each : words){
            allPhrases.add(each);
            unPhrases.add(each);
        }
        Phrase[] sorted = new Phrase[unPhrases.size()];
        int i = 0;
        for(String str : unPhrases){
            sorted[i] = new Phrase(str);
            sorted[i].count = Collections.frequency(allPhrases, str);
            i++;
        }
        Arrays.sort(sorted, Comparator.comparing(Phrase::count).reversed().thenComparing(Phrase::myPhrase));
        List<String> ans = new ArrayList<>();
        for(int j = 0; j < k; j++){
            ans.add(sorted[j].myPhrase);
        }
        return ans;
    }
}