/* Write a method remove that removes the node with the minimal value from the linked-list parameter list,
returning a linked list that has one less node than list since the minimal node is removed. The other nodes
in the returned list should be in the same order as they are in parameter list.

You can create a new list without the minimal value rather than removing the minimal node, the tester won't
differentiate between changing list or returning a new list with one fewer node than list when the minimal node is not present.

The ListNode class will be accessible when your method is tested. */

public class RemoveMin {
    public ListNode remove (ListNode list) {
        ListNode start = list;
        int min = list.info;
        while(list.next != null){
            if(list.next.info < min){
                min = list.next.info;
            }
            list = list.next;
        }
        list = start;
        if(list.info == min){
            start = list.next;
        }
        else while(list != null){
            if(list.next == null){
                break;
            }
            if(list.next.info == min){
                if(list.next.next != null){
                    list.next = list.next.next;
                }
                else{
                    list.next = null;
                }
            }
            list = list.next;
        }
        return start;
    }
}
