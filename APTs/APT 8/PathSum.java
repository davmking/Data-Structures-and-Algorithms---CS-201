/*Write a method that returns 1 if there is a root-to-leaf path whose node values sum
to target and returns 0 if there is no such root-to-leaf path.

For example, in the tree below there are exactly four root-to-leaf paths. The sums on
these paths are 27, 22, 26, 18, so hasPathSum(22,tree) will return 1 for the tree shown
and hasPathSum(32,tree) will return 0 for the tree shown. */

public class PathSum {
    public int hasPath(int target, TreeNode tree){
        if(tree == null){
            return 0;
        }
        if(tree.info == target){
            return 1;
        }
        if(hasPath(target - tree.info, tree.left) == 1 || hasPath(target - tree.info, tree.right) == 1){
            return 1;
        }
        return 0;
    }
}
