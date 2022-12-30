import java.util.Arrays;

public class FriendScore {
    public int highestScore(String[] friends) {
       int[] counts = new int[friends.length];
       for(int i = 0; i < friends.length; i++){
        for(int j = i + 1; j < friends.length; j++){
            if(friends[i].charAt(j) == 'Y'){
                counts[i]++;
                counts[j]++;
            }
            else for(int k = 0; k < friends.length; k++){
                if(friends[j].charAt(k) == 'Y' && friends[k].charAt(i) == 'Y'){
                    counts[i]++;
                    counts[j]++;
                    break;
                }
            }
        }
       }
       return Arrays.stream(counts).max().getAsInt();
    }
}