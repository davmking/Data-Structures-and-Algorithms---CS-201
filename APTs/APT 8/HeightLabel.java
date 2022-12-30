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