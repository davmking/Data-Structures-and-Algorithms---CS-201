public class HuffmanDecoding {
    public String decode(String archive, String[] dictionary) {
          int first = 0;
          int last = 1;
          int ASCII_START = 65;
          String ans = "";
          while(last <= archive.length()){
            String substr = archive.substring(first, last);
            for(int i = 0; i < dictionary.length; i++){
                if(dictionary[i].equals(substr)){
                    int curr = i + ASCII_START;
                    char current = (char) curr;
                    ans = ans + current;
                    first = last;
                    break;
                }
            }
            last++;
          }
          return ans;
    }
 }