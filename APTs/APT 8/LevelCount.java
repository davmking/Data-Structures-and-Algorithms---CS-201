public class LevelCount {
    int sum = 0;
    public int count(TreeNode t, int level) {
        if(t == null || level < 0){
            return sum;
        }
        if(level == 1){
            if(t.left != null){
                sum++;
            }
            if(t.right != null){
                sum++;
            }
            return sum;
        }
        else if(level == 0 && t != null){
            return 1;
        }
        count(t.left, level - 1);
        count(t.right, level - 1);
        return sum;
    }
}