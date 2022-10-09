/* Filtering data often requires determining which data elements satisfy a specific criterion.
Write method filter which has two parameters: a String[] of data to be filtered and an int parameter
indicating the minimum acceptable length for the string data.

Return a String[] array of the unique strings in list whose lengths are greater than or equal to minLength.

The string values in the returned array should be in the same order they appear in list. The strings in
the returned array should be unique, so conceptually only the first of any duplicate elements in list that
pass the length requirement is in the returned array. See the examples for details. */

import java.util.ArrayList;

public class StringCuts {
    public String[] filter(String[] list, int minLength) {
        ArrayList<String> unWords = new ArrayList<String>(list.length);
        for(int i = 0; i < list.length; i++){
            if(!unWords.contains(list[i])){
                unWords.add(list[i]);
            }
        }
        for(int j = 0; j < unWords.size(); j++){
            char[] len = unWords.get(j).toCharArray();
            if(len.length < minLength){
                unWords.remove(j);
                j--;
            }
        }
        String[] ans = new String[unWords.size()];
        for(int k = 0; k < unWords.size(); k++){
            ans[k] = unWords.get(k);
        }
        return ans;
    }
}
