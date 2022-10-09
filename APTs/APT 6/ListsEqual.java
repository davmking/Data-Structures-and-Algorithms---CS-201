/* Write a method equal that returns 1 if its two linked list parameters are equal, and returns 0 if they are not equal.

Two linked lists are considered equal if they have the same number of nodes and each node in the ith position in list a1
contains the same value is that contained in the ithe node of a2

The ListNode class will be accessible when your method is tested. */

public class ListsEqual {
    public int equal (ListNode a1, ListNode a2) {
        boolean checker = true;
        int len1 = 0;
        int len2 = 0;
        while(a1 != null && a2 != null){
            if(a1.info != a2.info){
                checker = false;
                break;
            }
            a1 = a1.next;
            len1++;
            a2 = a2.next;
            len2++;
        }
        while(a1 != null){
            a1 = a1.next;
            len1++;
        }
        while(a2 != null){
            a2 = a2.next;
            len2++;
        }
        if(len1 != len2){
            checker = false;
        }
        if(checker == false){
            return 0;
        }
        else{
            return 1;
        }
    }
}
