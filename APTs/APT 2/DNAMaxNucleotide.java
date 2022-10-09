/* Write code to find which of the strands representing DNA in an array String[] strand representing strands of DNA has
the most occurrences of the nucleotide represented by parameter nuc.

If more than one strand has the same maximal number of the specified nucleotide you should return the longest strand with
the maximal number. All DNA strands have different lengths in this problem so the maximal strand will be unique when length
is accounted for. Return this uniquely maximal strand.

Each String representing a DNA strand will contain only cytosine, guanine, thymine, and adenine, represented by the characters
'c', 'g', 't', and 'a', respectively. If no strand in the array contains the specified nucleotide return the empty string "". */

public class DNAMaxNucleotide {
    public String max(String[] strands, String nuc) {
        String ans = ""; 
        int count1 = 0; 
        char[] firstLetter = strands[0].toCharArray();
        int length1 = firstLetter.length;
        for(int i = 0; i < strands.length; i++){
            int count2 = 0;
            char[] letters = strands[i].toCharArray();
            int length2 = letters.length;
            for(int j = 0; j < letters.length; j++){
                if(strands[i].charAt(j) == nuc.charAt(0)){
                    count2++;
                }
            }
            if(count2 > count1){
                ans = strands[i];
                count1 = count2;
                length1 = length2;
            }
            else if(count2 == count1){
                    if(length2 > length1){
                        ans = strands[i];
                        length1 = length2;
                     }
                }
          }
        if(count1 == 0){
            return "";
        }
        else{
            return ans;
        }
    }
 }
