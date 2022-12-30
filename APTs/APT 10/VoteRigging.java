/*You have used your secret mind-reading device to find out how every voter will vote in the next election.
Your mind-reading device also revealed to you that all the voters are prepared to change their vote if you pay them enough.

The ith element of votes is the number of people who were originally planning to vote for candidate i.
Return the minimum number of votes that you must change to ensure that candidate 0 (your favorite) will have more votes than any other candidate. */

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
