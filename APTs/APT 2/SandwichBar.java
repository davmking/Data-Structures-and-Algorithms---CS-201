/* It's time to get something to eat and I've come across a sandwich bar. Like most people, I prefer certain types of sandwiches.
In fact, I keep a list of the types of sandwiches I like.

The sandwich bar has certain ingredients available. I will list the types of sandwiches I like in order of preference and buy the
first sandwich the bar can make for me. In order for the bar to make a sandwich for me, it must include all of the ingredients I desire.

Given a String[] available, a list of ingredients the sandwich bar can use, and a String[] orders, the types of sandwiches I like,
in order of preference (most preferred first), return the 0-based index of the sandwich I will buy. Each element of orders represents
one type of sandwich I like as a space-separated list of ingredients in the sandwich. If the bar can make no sandwiches I like, return -1. */

import java.util.Arrays;

public class SandwichBar {
    public int whichOrder(String[] available, String[] orders){
       int ans = 0;
       int catchAns = -1;
       for(int i = 0; i < orders.length; i++){
        String[] ingredients = orders[i].split(" ");
        boolean checker = Arrays.asList(available).containsAll(Arrays.asList(ingredients));
        if(checker == false){
            ans++;
        }
        else{break;}
       }
       if(ans == orders.length){
        return catchAns;
       }
       else{return ans;}
    }
 }
