import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LunchPlans {
    public String[] favorites(String[] preferences) {
        HashMap<String, Integer> foods = new HashMap<>();
        for(String pref : preferences){
            String[] ind = pref.split(" ");
            for(String each : ind){
                if(!foods.containsKey(each)){
                    foods.put(each, 1);
                }
                else{
                    int currentVal = foods.get(each);
                    foods.put(each, currentVal += 1);
                }
            }
        }
        List<String> removeKeys = new ArrayList<>();
        for(String key : foods.keySet()){
            if(foods.get(key) < preferences.length){
                removeKeys.add(key);
            }
        }
        for(String key : removeKeys){
            foods.remove(key);
        }
        String[] ansFoods = preferences[0].split(" ");
        String[] ans = new String[foods.keySet().size()];
        int i = 0;
        for(String each : ansFoods){
            if(foods.containsKey(each)){
                ans[i] = each;
                i++;
            }
        }
        return ans;
    }
}