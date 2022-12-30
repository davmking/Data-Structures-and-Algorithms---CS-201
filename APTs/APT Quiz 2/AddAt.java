public class AddAt {
    public ListNode addAt(ListNode list, ListNode toAdd, int index) {     
        if(toAdd == null){
            return list;
        }
        if(index == 0){
            ListNode otherFirst = toAdd;
            while(toAdd.next != null){
                toAdd = toAdd.next;
            }
            toAdd.next = list;
            return otherFirst;
        }
        ListNode first = list;
        for(int i = 0; i < index - 1; i++){
            list = list.next;
        }
        ListNode temp = list.next;
        list.next = toAdd;
        while(toAdd.next != null && toAdd != null){
            toAdd = toAdd.next;
        }
        toAdd.next = temp;
        return first;
    }
  }