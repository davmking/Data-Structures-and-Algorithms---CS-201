public class TreeCount {
    int sum = 0;
    public int count(TreeNode tree) {
        if(tree != null){
            sum++;
            count(tree.left);
            count(tree.right);
        }
        return sum;
    }
}