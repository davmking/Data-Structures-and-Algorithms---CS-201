import java.util.HashMap;
import java.util.HashSet;

public class Translate {
    public int numAlternates(String original, String translated) {
        HashMap<String, HashSet<String>> allWords = new HashMap<>();
        String[] origArray = original.split(" ");
        String[] transArray = translated.split(" ");
        for(int i = 0; i < origArray.length; i++){
            if(!allWords.containsKey(origArray[i])){
                HashSet<String> init = new HashSet<>();
                init.add(transArray[i]);
                allWords.put(origArray[i], init);
            }
            else{
                HashSet<String> curr = allWords.get(origArray[i]);
                curr.add(transArray[i]);
                allWords.put(origArray[i], curr);
            }
        }
        int ans = 0;
        for(String key : allWords.keySet()){
            HashSet<String> curr = allWords.get(key);
            if(curr.size() > 1){
                ans += curr.size();
            }
        }
        return ans;
    }
}