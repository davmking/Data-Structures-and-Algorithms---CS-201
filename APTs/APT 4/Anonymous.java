/* If you want to write a message anonymously, one way to do it is to cut out letters from headlines in a
newspaper and paste them onto a blank piece of paper to form the message you want to write. Given several
headlines that you have cut out, determine how many messages from a list you can write using the letters
from the headlines. You should only consider each message by itself and not in conjunction with the others, see example 2.

Write the method howMany which takes as parameters a String[] headlines containing the headlines which you
have cut out as well as a String[] messages with the messages you may want to write, and returns an int which
is the total number of messages you can write. */

import java.util.HashMap;
import java.util.Map;

public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {
          int ans = 0;
          Map<String, Integer> headMap = new HashMap<>();
          for(String h : headlines){
            h = h.toLowerCase();
            for(int i = 0; i < h.length(); i++){
                  if(!Character.isWhitespace(h.charAt(i))){
                        String letter = String.valueOf(h.charAt(i));
                  if(!headMap.containsKey(letter)){
                        headMap.put(letter, 1);
                  }
                  else if(headMap.containsKey(letter)){
                        int currentVal = headMap.get(letter);
                        headMap.put(letter, currentVal += 1);
                  }
                  }
            }
            }
            for(String message : messages){
                  Map<String, Integer> messageMap = new HashMap<>();
                  message = message.toLowerCase();
                  boolean checker = true;
                  for(int i = 0; i < message.length(); i++){
                        if(!Character.isWhitespace(message.charAt(i))){
                              String letter = String.valueOf(message.charAt(i));
                        if(!messageMap.containsKey(letter)){
                              messageMap.put(letter, 1);
                        }
                        else if(messageMap.containsKey(letter)){
                              int currentVal = messageMap.get(letter);
                              messageMap.put(letter, currentVal += 1);
                        }
                        if(!headMap.containsKey(letter)){
                              checker = false;
                              break;
                        }
                        else if(messageMap.get(letter) > headMap.get(letter)){
                              checker = false;
                              break;
                        }
                        }
                  }
                  if(checker == true){
                        ans += 1;
                  }
            }
          return ans;
    }
 }
