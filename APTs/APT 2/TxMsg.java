/* Strange abbreviations are often used to write text messages on uncomfortable mobile devices. One particular strategy for
encoding texts composed of alphabetic characters and spaces is the following:

    Spaces are maintained, and each word is encoded individually. A word is a consecutive string of alphabetic characters.

    If the word is composed only of vowels, it is written exactly as in the original message.

    If the word has at least one consonant, write only the consonants that do not have another consonant immediately before them. Do not write any vowels.

    The letters considered vowels in these rules are 'a', 'e', 'i', 'o' and 'u'. All other letters are considered consonants. 

For instance, "ps i love u" would be abbreviated as "p i lv u" while "please please me" would be abbreviated as "ps ps m".
You will be given the original message in the string parameter original. Return a string with the message abbreviated using the described strategy. */

import java.util.*;

public class TxMsg {
    public String getMessage(String original) {
      String ans = "";
      String vowels = "aeiou";
      String[] words = original.split(" ");
      for(int i = 0; i < words.length; i++){
        Boolean consonantChecker = false;
        StringBuilder word = new StringBuilder(words[i]);
        if(vowels.contains(word.charAt(0)) && consonantChecker == false){
            ans += word.charAt(0);
        }
        else if(!vowels.contains(word.charAt(0)) && consonantChecker == true){
            ans += word.charAt(0);
        }
        for(int j = word.length; j > 0; j--){
            if(!vowels.contains(word.charAt(j-1))){
                consonantChecker = true;
                word.deleteCharAt(j);
            }
        }
      }
    return ans;
    }
 }
