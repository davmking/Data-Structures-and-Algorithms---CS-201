import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class DepthOrder {
    TreeMap<Integer, ArrayList<Integer>> levels = new TreeMap<>();
    int treeSize = 0;
    public int[] order(TreeNode root) {
        eachLevel(root, 0);
        int[] ans = new int[treeSize];
        int i = 0;
        for(Integer next : levels.keySet()){
            ArrayList<Integer> curr = levels.get(next);
            Collections.sort(curr);
            for(int j = 0; j < curr.size(); j++){
                ans[i] = curr.get(j);
                i++;
            }
        }
        return ans;
    }

    public void eachLevel(TreeNode root, Integer level){
        if(root == null){
            return;
        }
        treeSize++;
        if(!levels.containsKey(level)){
            levels.put(level, new ArrayList<Integer>());
            ArrayList<Integer> current = levels.get(level);
            current.add(root.info);
            levels.put(level, current);
        }
        else{
            ArrayList<Integer> current = levels.get(level);
            current.add(root.info);
            levels.put(level, current);
        }
        if(root.left != null){
            eachLevel(root.left, level + 1);
        }
        if(root.right != null){
            eachLevel(root.right, level + 1);
        }
    }
}