import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeMap;

public class SortByFreqs {
    
    public class Phrase {
        public String myPhrase;
        public int count;
        
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

    public String[] sort(String[] data) {
        ArrayList<String> allPhrases = new ArrayList<>();
        HashSet<String> unPhrases = new HashSet<>();
        for(String each : data){
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
        String[] ans = new String[sorted.length];
        for(int j = 0; j < sorted.length; j++){
            ans[j] = sorted[j].myPhrase;
        }
        return ans;
    }
 }