/* Write method anywhere that finds each word that appears in any element of parameter String[] list and returns
a String containing these words in alphabetical order, each separated by a space.

Each word in the string returned should be unique/different.

Each element of list is a string of words, each separated by a space. Each of these words, that appear in any element of list, are represented in the string returned.

See the examples for details.

Note that Arrays.sort(a) sorts an array a and Collections.sort(alist) sorts an ArrayList alist. You can also use a TreeSet which stores words in order. */

import java.util.TreeSet;

public class Closet {
    public String anywhere(String[] list) {
        TreeSet<String> allWords = new TreeSet<>();
        for(String element : list){
            String[] words = element.split(" ");
            for(String word : words){
                allWords.add(word);
            }
        }
        return String.join(" ", allWords);
    }
}
