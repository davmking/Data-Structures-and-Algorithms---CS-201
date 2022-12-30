import java.util.Arrays;
import java.util.Collections;

public class OlympicCandles{
    public int numberOfNights(int[] candles){
       int sumHeight = 0;
       int numNights = 0;
       int numCandles = candles.length;
       Arrays.sort(candles);
       int[] rev = new int[candles.length];
       int j = 0;
       for(int i = candles.length - 1; i >= 0; i--){
        rev[j++] = candles[i];
       }
       for(int i = 0; i < candles.length; i++){
        sumHeight += rev[i];
       } 
       //Need to sort the array again at every iteration
       while(((sumHeight - numNights) > 0) && (numCandles > numNights)){
        numNights++;
        sumHeight -= numNights;
        for(int i = 0; i < numNights; i++){
            while(rev[i] == 0){
                i++;
                if(i >= rev.length){
                    return numNights - 1;
                }
            }
            if(rev[i] == 1){
                numCandles--;
            }
            rev[i]--;
        }
       }
       return numNights;
    }

    public static void main(String[] args){
        int[] candles = {2, 2, 2};
        OlympicCandles test = new OlympicCandles();
        int n = test.numberOfNights(candles);
        System.out.println(n);
    }
  }