import java.util.ArrayList;
import java.util.List;

public class LeafCollector {
    String[] ans;
    List<String> curr = new ArrayList<>();
    public String[] getLeaves(TreeNode tree) {
        ans = new String[checkDepth(tree)];
        if(tree == null){
            return new String[0];
        }
        int i = 0;
        while(!isLeaf(tree)){
            allLeaves(tree, curr);
            ans[i++] = String.join(" ", curr);
            curr.clear();
        }
        ans[ans.length - 1] = String.valueOf(tree.info);
        return ans;
    }

    public int checkDepth(TreeNode tree){
        if(tree == null){
            return 0;
        }
        else{
            int lDepth = checkDepth(tree.left);
            int rDepth = checkDepth(tree.right);
            if(lDepth > rDepth){
                return lDepth + 1;
            }
            else{
                 return rDepth + 1;
            }
        }
    }

    public void allLeaves(TreeNode tree, List<String> currLevel){
        if(isLeaf(tree.left)){
            currLevel.add(String.valueOf(tree.left.info));
            tree.left = null;
        }
        if(!isLeaf(tree.left) && tree.left != null){
            allLeaves(tree.left, curr);
        }
        if(isLeaf(tree.right)){
            currLevel.add(String.valueOf(tree.right.info));
            tree.right = null;
        }
        if(!isLeaf(tree.right) && tree.right != null){
            allLeaves(tree.right, curr);
        }
    }

    public boolean isLeaf(TreeNode t){
        if(t == null){
            return false;
        }
        else if(t.left == null && t.right == null){
            return true;
        }
        return false;
    }
}