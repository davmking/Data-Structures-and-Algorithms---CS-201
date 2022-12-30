/*Write method count that returns the number of nodes in a tree at the level specified by
parameter level. The root is at level 0, and the root's children are at level 1. In general,
for any node, it's level is one more than its parent's level.

In the tree diagrammed below, the call count(t,1) should return 2 since 6 and 12 are at level 1.
The call count(t,3) should return 0 since there are no nodes at level 3. The call count(t,2) 
should return 3 -- each leaf is at level 3. */

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
