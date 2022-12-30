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