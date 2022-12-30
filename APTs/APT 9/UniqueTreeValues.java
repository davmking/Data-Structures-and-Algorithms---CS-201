import java.util.TreeSet;

public class UniqueTreeValues {
    public TreeSet<Integer> unValues = new TreeSet<>();
    public int[] unique(TreeNode root) {
        if(root != null){
            unValues.add(root.info);
            unique(root.left);
            unique(root.right);
        }
        return sorted(unValues);
    }

    public int[] sorted(TreeSet<Integer> vals){
        int[] ans = new int[vals.size()];
        int i = 0;
        for(Integer each : vals){
            ans[i++] = each;
        }
        return ans;
    }
}