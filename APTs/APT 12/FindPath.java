import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindPath {
    ArrayList<String> paths = new ArrayList<>();
    public String path(TreeNode root, int target) {
        allPaths(root, "", target);
        Collections.sort(paths, Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        if(paths.size() == 0){
            return "nopath";
        }
        return paths.get(0);
    }

    public void allPaths(TreeNode t, String path, int target){
        if(t == null){
            return;
        }
        if(t.info == target){
            paths.add(path);
            return;
        }
        allPaths(t.left, path + "0", target);
        allPaths(t.right, path + "1", target);
    }
}