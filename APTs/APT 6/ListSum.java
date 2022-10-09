/* Write a method sum that returns the sum of the values greater than thresh in its list parameter, a linked list of int values;

The ListNode class will be accessible when your method is tested. */

public class ListSum {
    public int sum(ListNode list, int thresh) {
        int ans = 0;
        while(list != null){
            if(list.info > thresh){
                ans += list.info;
            }
            list = list.next;
        }
        return ans;
    }
}
