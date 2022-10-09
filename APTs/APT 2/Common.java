/* Two strings have a letter in common if it appears in both strings. The position of letter is not important for it to be counted as common.
Once a particular letter is counted as in common, it cannot be counted again. For example, an o appearing twice in one word but only once in
the other counts only as one letter in common. However, an o appearing twice both words counts as two letters in common.

Write a function that takes two strings and returns the number of letters they have in common.

Hint: you will need some way to avoid counting a letter more than once if it is in common to both words. Recall that strings are immutable. */

public class Common {
    public int count (String a, String b) {
       int ans = 0;
       StringBuilder a2 = new StringBuilder(a);
       StringBuilder b2 = new StringBuilder(b);
       for(int i = 0; i < a2.length(); i++){
        for(int j = 0; j < b2.length(); j++){
            if(a2.charAt(i) == b2.charAt(j)){
                ans++;
                a2.deleteCharAt(i);
                b2.deleteCharAt(j);
                i--;
                break;
            }
        }
       }
       return ans;
    }
 }
