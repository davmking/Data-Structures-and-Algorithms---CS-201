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