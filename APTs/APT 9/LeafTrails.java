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