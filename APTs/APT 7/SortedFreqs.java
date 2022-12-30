import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class SortedFreqs {
    public int[] freqs(String[] data) {
      ArrayList<String> allWords = new ArrayList<>();
      TreeSet<String> unWords = new TreeSet<>();
      for(String each : data){
        allWords.add(each);
        unWords.add(each);
      }
      int[] ans = new int[unWords.size()];
      int i = 0;
      for(String each : unWords){
        ans[i++] = Collections.frequency(allWords, each);
      }
      return ans;
    }
 }