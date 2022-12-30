/*Write method rewire that returns a new tree, isomorphic (same shape) as the tree parameter,
but in which each node's info field is equal to that node's height in the tree.

Given the tree diagrammed below on the left, the tree returned should be as diagrammed on the right.
The values in the tree passed as a parameter don't matter. You'll write code to create a new tree in
which the value in each node is that node's height in the tree returned. Recall that height is measured
in nodes, and it's the length of the longest root-to-leaf path in a tree. */

public class HeightLabel {
    //public int num = 0;
    public TreeNode rewire(TreeNode t) {
        if(t.left == null && t.right == null){
            t.info = 1;
            return t;
        }
        if(t.left != null && t.right == null){
            t.info = 1 + rewire(t.left).info;
        }
        if(t.right != null && t.left == null){
            t.info = 1 + rewire(t.right).info;
        }
        if(t.right != null && t.left != null){
            t.info = 1 + Math.max(rewire(t.left).info, rewire(t.right).info);
        }
        return t;
    }
}
