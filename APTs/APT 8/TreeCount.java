/*Write a method that returns the number of nodes of a binary tree. The TreeNode class will be accessible when your method is tested. */

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
