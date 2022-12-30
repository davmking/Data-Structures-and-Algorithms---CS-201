public class CountShapes {
    int ans = 0;
    int totalNodes = 0;
    String shape = "T";
    public int count(TreeNode countThis, TreeNode root) {
          getShape(countThis);
          System.out.println(shape);
          allNodes(root, "T", shape);
          return ans;
      }

    public void getShape(TreeNode init){
        if(init == null){
            return;
        }
        if(init.left != null && init.right != null){
            shape += "T";
            getShape(init.left);
            shape += "T";
            getShape(init.right);
        }
        else if(init.right == null && init.left != null){
            shape += "TF";
            getShape(init.left);
        }
        else if(init.left == null && init.right != null){
            shape += "FT";
            getShape(init.right);
        }
        /*else{
            shape += "FF";
        }*/
        return;
    }

    public void countShape(TreeNode t, String curr, String shape){
        if(t == null){
            return;
        }
        if(curr.length() == shape.length()){
            char[] currChars = curr.toCharArray();
            char[] theShape = shape.toCharArray();
            for(int i = 0; i < theShape.length; i++){
                if(theShape[i] == 'F'){
                    currChars[i] = 'F';
                }
                curr = currChars.toString();
            }
            if(curr.equals(shape)){
                ans++;
            }
        }
        if(t.right != null && t.left != null){
            curr += "T";
            countShape(t.left, curr, shape);
            curr += "T";
            countShape(t.right, curr, shape);
        }
        else if(t.right == null && t.left != null){
            curr += "TF";
            countShape(t.left, curr, shape);
        }
        else if(t.left == null && t.right != null){
            curr += "FT";
            countShape(t.right, curr, shape);
        }
        else{
            curr += "FF";
        }
        return;
    }

    public void allNodes(TreeNode t, String curr, String shape){
        if(t != null){
            countShape(t, curr, shape);
            allNodes(t.left, curr, shape);
            allNodes(t.right, curr, shape);
        }
    }

    public static void main(String[] args){
        CountShapes test = new CountShapes();
        TreeNode init = new TreeNode(1);
        init.right = new TreeNode(2);
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(15);
        int a = test.count(init, root);
        System.out.println(a);
    }
  }