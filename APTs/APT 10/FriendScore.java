/*You want to determine the most popular person in a social network. To do this, you will count the number of "2-friends"
that each person has. Person A is called a 2-friend of another person B if they are friends with each other or if there exists
some person C who is a friend of both A and B. The most popular person is the person with the highest number of 2-friends.
(There might be more than one if multiple people all have the maximal number of 2-friends.)

You are given a String[] friends, where the j-th character of the i-th element is 'Y' if person i and person j are friends,
and 'N' otherwise. Return the number of 2-friends of the most popular person in this social network. */

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
