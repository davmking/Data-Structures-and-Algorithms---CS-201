public class ListShift {
    public ListNode shift(ListNode start, int key) {
        ListNode current = start;
        ListNode start2 = null;
        ListNode curr2 = null;
        if(start.info > key){
            start2 = start;
            curr2 = start2;
        }
        while(current != null){
            if(current.next != null && current.next.info > key){
                ListNode temp = current.next;
                current.next = current.next.next;
                if(start2 == null){
                    start2 = temp;
                    start2.next = start;
                    curr2 = start2;
                }
                else{
                    curr2.next = temp;
                    curr2 = curr2.next;
                    if(start2 != start){
                        curr2.next = start;
                    }
                    else{
                        current = current.next;
                    }
                }
            }
            else{
                current = current.next;
            }
        }
        if(start2 == null){
            return start;
        }
        return start2;
    }
}