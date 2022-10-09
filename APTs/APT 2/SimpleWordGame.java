/*The Simple Word Game is a game where a player tries to remember as many words as possible from a given dictionary.
The score for each distinct word that the player remembers correctly is the square of the word's length.

You are given a String[] player, each element of which is a word remembered by the player. There may be duplicate words,
but if the same word appears multiple times, it should only be counted once. You are given the dictionary in the String[]
dictionary, each element of which is a single distinct word. Return the player's total score. */

import java.util.*;

public class SimpleWordGame {
    public int points(String[] player, 
                      String[] dictionary) {
        int ans = 0;
        Set<String> unWords = new HashSet<>(Arrays.asList(player));
        for(String it : unWords){
            char[] letters = it.toCharArray();
            if(Arrays.asList(dictionary).contains(it)){
                ans += letters.length * letters.length;
            }
        }
        return ans;
    }
}
