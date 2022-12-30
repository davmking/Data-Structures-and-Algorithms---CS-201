/*The frequency with which data occurs is sometimes an important statistic. In this problem you are given
an array of strings and must determine how frequently the strings occur. Return an array of strings that is
sorted (ordered) by frequency. The first element of the returned array is the most frequently occurring string,
the last element is the least frequently occurring. Ties are broken by listing strings in lexicographic/alphabetical
order. The returned array contains one occurrence of each unique string from the array parameter.

Consider these strings (quotes for clarity, they're not part of the strings).


{"apple", "pear", "cherry", "apple", "pear", "apple", "banana"}

The array returned is:

   { "apple", "pear", "banana", "cherry" }

since the most frequently occurring string is "apple" which occurs 3 times; the string "pear" occurs twice and
the other strings each occur once so they are returned in alphabetical order. */

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
