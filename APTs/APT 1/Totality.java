/*The phrases even keeled, odd job, and total eclipse might come to mind as you solve this APT. Given an array of int values,
return the sum of those values that are at odd indexes, even indexes, or every index depending on whether the value of the String
stype is "odd", "even", or "all", respectively. See examples for details. */

public class Totality {
    public int sum(int[] a, String stype) {
        int ans = 0;
        if(stype.equals("odd")){
            for(int i = 1; i < a.length; i+=2){
                ans = ans + a[i];
            }
        }
        else if(stype.equals("even")){
            for(int i = 0; i < a.length; i+=2){
                ans = ans + a[i];
            }
        }
        else if(stype.equals("all")){
            for(int i = 0; i < a.length; i++){
                ans = ans + a[i];
            }
        }
        return ans;
    }
}
