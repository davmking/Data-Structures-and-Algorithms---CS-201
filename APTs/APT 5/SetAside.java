/* Write method common that finds each word that appears in every element of parameter String[] list
and returns a String containing these words in alphabetical order, each separated by a space.

Each word in the string returned should be unique/different.

Each element of list is a string of words, each separated by a space. If there are no words that appear
in each and every element of list return an empty string: "". See the examples for details.

Note that Arrays.sort(a) sorts an array a and Collections.sort(alist) sorts an ArrayList alist.

Also String.join(" ",collection) returns a string with each element of collection separated by a space. */

import java.util.ArrayList;
import java.util.TreeSet;

public class SetAside {
    public String common(String[] list) {
        TreeSet<String> all = new TreeSet<>();
        String[] first = list[0].split(" ");
        for(String word : first){
            all.add(word);
        }
        ArrayList<String> removeWords = new ArrayList<>();
        for(int i = 1; i < list.length; i++){
            String[] words = list[i].split(" ");
            ArrayList<String> wordsList = new ArrayList<>();
            for(String word : words){
                wordsList.add(word);
            }
            for(String word : all){
                if(!wordsList.contains(word)){
                    removeWords.add(word);
                }
            }
        }
        for(String word : removeWords){
            all.remove(word);
        }
        String ans = String.join(" ", all);
        return ans;
    }
}
