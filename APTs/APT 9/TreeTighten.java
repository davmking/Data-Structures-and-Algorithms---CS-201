/*Write method tighten that removes every node with a single child (either left or right),
replacing such nodes with their single child. This tightening process is repeatedly applied
so that when completed all nodes have either zero or two children.

In the tree diagrammed below, the call tighten(t) applied to the tree on the left modifies and
returns the tree shown on the right. Note that the nodes with one child on the left: 22, 18, and 15
are each removed and replaced by their single child. For 22 this means that 13 left's child is
8 and 13's right child is 25 since both 18 and 15 are removed. */

public class TreeTighten {
        public TreeNode tighten(TreeNode t) {
            if(t == null || (t.left == null && t.right == null)){
                return t;
            }
            if(t.left == null && t.right != null){
                return tighten(t.right);
            }
            if(t.left != null && t.right == null){
                return tighten(t.left);
            }
            if(t.left != null && t.right != null){
                t.left = tighten(t.left);
                t.right = tighten(t.right);
            }
            return t;
        }
    }
