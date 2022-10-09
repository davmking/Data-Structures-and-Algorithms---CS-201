/* Write a method stretch that stretches a linked list of integers by a specified integer value amount,
so that each node of the list parameter is represented by amount copies of the node in the list that's returned.

The ListNode class will be accessible when your method is tested. */

public class ListStretch {
    public ListNode stretch (ListNode list, int amount){
        ListNode ans = list;
        while(list != null){
            for(int i = 0; i < amount - 1; i++){
                ListNode list2 = new ListNode(list.info);
                list2.next = list.next;
                list.next = list2;
                list = list.next;
            }
            list = list.next;
        }
        return ans;
    }
}
