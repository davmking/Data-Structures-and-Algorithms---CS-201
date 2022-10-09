/*  Write a method fold that has an int[] parameter and that returns an int[] array formed
by summing each adjacent pairs of integer values in the parameter.

For example, if list is {7, 2, 8, 9, 4, 13, 7, 1, 9, 10}, then the returned array is {9, 17, 17, 8, 19}.

Note that 7 + 2 = 9, 8+9 = 17, 4+13 = 17, 7+1=8, and 9+10=19. If list stores an odd number of elements,
the final element is summed with zero since there is no adjacent value. For example, for {1, 2, 3, 4, 5} the return array is {3, 7, 5}. */

public class PairDown {
    public int[] fold(int[] list) {
        double listLen = list.length;
        double divisor = 2;
        double len = Math.ceil(listLen / divisor);
        int newLen = (int) len;
        int[] ans = new int[newLen];
        if((double) list.length % 2 == 1){
            int i = 0;
            int j = 1;
            for(int k = 0; k < ans.length - 1; k++){
                ans[k] = list[i] + list[j];
                i += 2;
                j += 2;
            }
            ans[ans.length - 1] = list[i];
        }
        else{
            int i = 0;
            int j = 1;
            for(int k = 0; k < ans.length; k++){
                ans[k] = list[i] + list[j];
                i += 2;
                j += 2;
            }
        }
        return ans;
    }
}
