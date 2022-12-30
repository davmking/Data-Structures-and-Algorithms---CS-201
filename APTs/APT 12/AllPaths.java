import java.util.ArrayList;
import java.util.Collections;

public class AllPaths {
    ArrayList<String> paths = new ArrayList<>();
    public String[] paths(TreeNode t) {
        if(t == null){
            return new String[0];
        }
        else if(t.left == null && t.right == null){
            Integer newT = t.info;
            String ret = newT.toString();
            String[] retArr = new String[1];
            retArr[0] = ret;
            return retArr;
        }
        allPaths(t, "");
        Collections.sort(paths);
        String[] fin = new String[paths.size()];
        for(int i = 0; i < fin.length; i++){
            fin[i] = paths.get(i);
        }
        return fin;
    }

    public void allPaths(TreeNode t, String path){
        if(t == null){
            return;
        }
        if(t.left == null && t.right == null){
            paths.add(path + t.info);
            return;
        }
        allPaths(t.left, path + t.info + "->");
        allPaths(t.right, path + t.info + "->");
    }
}