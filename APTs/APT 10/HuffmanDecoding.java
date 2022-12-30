/*When text is encoded using Huffman codes, each symbol is replaced by a string of 0s and 1s
called a bit string representation. The replacement is done in such a way that the bit string
representation of a symbol is never the prefix of the bit string representation of any other symbol.
This property allows us to unambiguously decode the encoded text.

You will be given a String archive and a String[] dictionary. The i-th element of dictionary will be
the bit string representation of the i-th uppercase letter. Decode archive using dictionary and return the result as a single String. */

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
