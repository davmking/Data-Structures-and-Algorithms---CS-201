/* In soccer, all the major national leagues are conducted in the following way:

A league consists of several teams. Over the course of a year, each team must play exactly two matches
against each of the other teams - one at its own stadium and one at the opponent's stadium. When a team
plays at its own stadium, it is called the "home team" and its opponent is called the "away team". Each
match ends in one of three possible results: a home team victory, a draw, or an away team victory. Each
time a team wins, it is awarded 3 points. When there's a draw, both teams are awarded 1 point. No points
are awarded for a loss. The overall ranking of the teams is based on the total number of points received by each team.

You are given a String[] matches. The j-th character of the i-th element of matches denotes the result of
the match between team i and team j at team i's stadium. 'W' represents a home team victory, 'D' represents
a draw, and 'L' represents an away team victory. All characters on the main diagonal of matches will be '-'
because a team never plays against itself. Return a int[] where the i-th element is the total number of points received by the i-th team. */

public class SoccerLeagues {
    public int[] points(String[] matches) {
        int[] ans = new int[matches.length];
        for(int i = 0; i < matches.length; i++){
            for(int j = 0; j < matches[i].length(); j++){
                if(matches[i].charAt(j) == 'W'){
                    ans[i] += 3;
                }
                if(matches[i].charAt(j) == 'D'){
                    ans[i] += 1;
                    ans[j] += 1;
                }
                if(matches[i].charAt(j) == 'L'){
                    ans[j] += 3;
                }
            }
        }
        return ans;
    }
}
