/*Circles Country is a country that contains several circular-shaped districts. Some districts may be situated inside other districts,
but their borders do not intersect or touch. Qatam is a resident of Circles Country. When he travels between two locations, he always
tries to cross the fewest number of district borders as possible because crossing borders is usually a laborious task.

Imagine Circles Country as an infinite plane. You are given int[] x and int[] y and int[] r, where (x[i],y[i]) are the coordinates of the
i-th district's center and r[i] is its radius. Qatam is currently at point (x1,y1) and he needs to get to point (x2,y2). Neither of these
points lies on a district border. Return the minimal number of district borders he must cross to get to his destination. */

public class CirclesCountry {
    public int leastBorders(int[] x, int[] y, int[] r, 
                            int x1, int y1, int x2, int y2) {
        String[] firstInside = new String[x.length];
        String[] secondInside = new String[x.length];
        for(int i = 0; i < x.length; i++){
            if(Math.sqrt((y1 - y[i]) * (y1 - y[i]) + (x1 - x[i]) * (x1 - x[i])) < r[i]){
                firstInside[i] = "True";
            }
            else{firstInside[i] = "False";}
        }
        for(int i = 0; i < x.length; i++){
            if(Math.sqrt((y2 - y[i]) * (y2 - y[i]) + (x2 - x[i]) * (x2 - x[i])) < r[i]){
                secondInside[i] = "True";
            }
            else{secondInside[i] = "False";}
        }
        int ans = 0;
        for(int i = 0; i < x.length; i++){
            if(!firstInside[i].equals(secondInside[i])){
                ans += 1;
            }
        }
        return ans;
    }
 }
