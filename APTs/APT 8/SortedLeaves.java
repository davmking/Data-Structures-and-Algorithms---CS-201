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