/* Write a method create that creates a linked-list of nodes whose values are the lengths of
the unique strings in words when considered in alphabetical order.

For example, if words = ["dog", "cat", "yak", "cow", "cat", "dog"] the return list would represent
the word-lengths of ["cat", "cow", "dog", "yak"] and the method you write would return a linked-list
represented by [3,3,3,3]. The ListNode class will be accessible when your method is tested. */

import java.util.TreeSet;

public class AlphaLength {
    public ListNode create (String[] words) {
        TreeSet<String> unWords = new TreeSet<>();
        for(String word : words){
            unWords.add(word);
        }
        int[] lenList = new int[unWords.size()];
        int i = 0;
        for(String word : unWords){
            lenList[i] = word.length();
            i++;
        }
        ListNode ans = new ListNode(lenList[0]);
        ListNode first = ans;
        for(int j = 1; j < lenList.length; j++){
            ListNode second = new ListNode(lenList[j]);
            first.next = second;
            first = second;
        }
        return ans;
    }
}
