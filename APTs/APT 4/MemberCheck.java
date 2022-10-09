/* A health club chain allows its members to visit any of its many health club locations an unlimited
number of times per day. The only constraining rule is, a customer can only visit one health club location
per day, even though he or she may return to that location an unlimited number of times for the rest of that day.

Although the honor system has always worked quite well, the club wants to run some tests to see how many
people really follow the rules. You are to write a program that takes the entrance log files from three
different clubs (all logging the same day) and return a sorted list of the people who are not honest and
went to more than one health club location in the same day.

The log files are represented as String[]'s where each element is the member name of a customer who entered
that day. For example, if a customer showed up three times to one of the club locations that day, the member's
name would appear three times in the corresponding String[]. */

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class MemberCheck {
    public String[] whosDishonest(String[] club1, 
                                  String[] club2, 
                                  String[] club3) {
            Set<String> club1Set = new TreeSet<>(Arrays.asList(club1));
            Set<String> club2Set = new TreeSet<>(Arrays.asList(club2));
            Set<String> club3Set = new TreeSet<>(Arrays.asList(club3));
            Set<String> cheaters = new TreeSet<>();
            for(String member : club1Set){
                if(club2Set.contains(member)){
                    cheaters.add(member);
                }
                if(club3Set.contains(member)){
                    cheaters.add(member);
                }
            }
            for(String member : club2Set){
                if(club3Set.contains(member)){
                    cheaters.add(member);
                }
            }
            String[] ans = new String[cheaters.size()];
            int i = 0;
            for(String cheater : cheaters){
                ans[i++] = cheater;
            }
        return ans;
    }
 }
