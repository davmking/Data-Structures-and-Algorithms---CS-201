/*Write method trails that returns an array of the binary encoded root-to-leaf paths for each leaf node of its tree parameter tree.

Values stored in leaf nodes will be unique, that is the same value will not appear in more than one leaf.

In traversing from the root to a leaf a path is represented by going left or right. Going left is encoding
by a zero and going right is encoded by a one. The path left,left,right would thus be encoded as "001" in the binary encoding of the root-to-leaf path.

The strings stored in the array should be sorted by the value stored in the leaf node represented by the path. See the examples for details. */

import java.util.TreeMap;

public class LeafTrails {
    public TreeMap<Integer, String> myMap = new TreeMap<>();
    public String[] trails(TreeNode tree) {
        String myPath = "";
        allPaths(tree, myPath);
        return getAll(myMap);
    }

    public void allPaths(TreeNode t, String path){
        if(t == null){
            return;
        }
        if(t.left == null && t.right == null){
            myMap.put(t.info, path);
            t = null;
            return;
        }
        allPaths(t.left, path + "0");
        allPaths(t.right, path + "1");
    }

    public String[] getAll(TreeMap<Integer, String> thisMap){
        String[] ans = new String[thisMap.keySet().size()];
        int i = 0;
        for(Integer key: thisMap.keySet()){
            ans[i++] = thisMap.get(key).toString();
        }
        return ans;
    }
}
