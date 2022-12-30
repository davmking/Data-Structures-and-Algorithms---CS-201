import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class Increasing {

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

    public int[] getIncreasing(int[] numbers) {
        ArrayList<String> allPhrases = new ArrayList<>();
        HashSet<String> unPhrases = new HashSet<>();
        for(String each : numbers){
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