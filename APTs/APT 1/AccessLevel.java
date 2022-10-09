public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
        String ans = "";
           for(int i = 0; i < rights.length; i++) {
                if(rights[i] >= minPermission){
                    ans += "A";
                }
                else if(rights[i] < minPermission){
                    ans += "D";
                }
           }
           return ans;
    }
 }
