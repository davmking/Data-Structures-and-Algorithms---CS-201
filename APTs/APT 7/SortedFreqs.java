/*The frequency with which data occurs is sometimes an important statistic. In this problem
you'll determine how frequently strings occur and return an array representing the frequencies
of each different/unique string. The array returned contains as many frequencies as there are
unique strings. The returned frequencies represent an alphabetic/lexicographic ordering of the
unique words, so the first frequency is how many times the alphabetically first word occurs and
the last frequency is the number of times the alphabetically last word occurs.

Consider these strings (quotes for clarity, they're not part of the strings).


{"apple", "pear", "cherry", "apple", "cherry", "pear", "apple", "banana"}

The array returned is {3,1,2,2} since the alphabetically first word is "apple" which occurs 3 times;
the second word alphabetically is "banana" which occurs once, and the other words each occur twice. */

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
