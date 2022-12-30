public class VoteRigging {
    public int minimumVotes(int[] votes) {
        int max = findMax(votes);
        int ans = 0;
        while(max != 0){
            votes[0]++;
            votes[max]--;
            ans++;
            max = findMax(votes);
        }
        return ans;
    }

    public int findMax(int[] votes){
        int ret = 0;
        for(int i = 0; i < votes.length; i++){
            if(votes[i] >= votes[ret]){
                ret = i;
            }
        }
        return ret;
    }
 }