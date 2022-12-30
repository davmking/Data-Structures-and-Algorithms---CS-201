public class CountShapes {
    int ans = 0;
    public int count(TreeNode countThis, TreeNode root) {
          String shape = getShape(countThis, "T");
          System.out.println(shape);
          countShape(root, "T", shape);
          return ans;
      }

    public String getShape(TreeNode init, String currShape){
        if(init == null){
            return "";
        }
        if(init.right == null && init.left != null){
            getShape(init.left, currShape + "T");
        }
        else if(init.left == null && init.right != null){
            getShape(init.right, currShape + "FT");
        }
        else if(init.left != null && init.right != null){
            getShape(init.left, currShape + "TT");
            getShape(init.right, currShape + "TT");
        }
        return currShape;
    }

    public void countShape(TreeNode t, String curr, String shape){
        if(t == null){
            return;
        }
        if(curr.length() == shape.length()){
            if(curr.equals(shape)){
                ans++;
            }
            curr = "";
        }
        if(t.right == null && t.left != null){
            getShape(t.left, curr + "T");
        }
        else if(t.left == null && t.right != null){
            getShape(t.right, curr + "FT");
        }
        else if(t.left != null && t.right != null){
            getShape(t.left, curr + "TT");
            getShape(t.right, curr + "TT");
        }
        return;
        /*if(t.left == null){
            curr += "F";
        }
        else if(t.left != null){
            countShape(t.left, curr, shape);
        }
        if(t.right == null){
            curr += "F";
        }
        else if(t.right != null){
            countShape(t.right, curr, shape);
        }
            return;*/
    }

    public static void main(String[] args){
        CountShapes test = new CountShapes();
        TreeNode init = new TreeNode(1);
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(15);
        int ans = test.count(init, root);
        System.out.println(ans);
    }
  }