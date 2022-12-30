/*Write method values that returns the values stored in the leaves of its tree parameter tree.
Each value stored in in a leaf is a number between 65 and 90, inclusive, and should be interpreted
as a corresponding letter "A" through "Z".

The values should be returned as a sorted array of strings, each string a single letter "A" through "Z".

Leaves have no children. */

import java.util.ArrayList;
import java.util.Collections;

public class SortedLeaves {
    ArrayList<String> vals = new ArrayList<>();
    public String[] values(TreeNode tree) {
        getVals(tree);
        Collections.sort(vals);
        String[] ret = new String[vals.size()];
        for(int i = 0; i < ret.length; i++){
            ret[i] = vals.get(i);
        }
        return ret;
    }

    public void getVals(TreeNode tree){
        if(tree == null){
            return;
        }
        if(tree.left == null && tree.right == null){
            vals.add(String.valueOf(((char)tree.info)));
            return;
        }
        getVals(tree.left);
        getVals(tree.right);
    }
}
