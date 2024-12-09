/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        int size = 0;

        while(curr != null){
            curr = curr.next;
            size++;
        }
        curr = head;
        
        while(curr != null && size - k >= 0){
            int count = 0;
            ListNode after = null,prev = null;
            
            while(count != k ){
                after = curr.next;
                curr.next = prev;
                prev = curr;
                curr = after;
                count++;
            }
            size -= k;
            
            list.add(prev);
        }
        list.add(curr);

        ListNode res = list.get(0);
        ListNode newCurr = res;
        for (int i = 1 ; i < list.size() ; i++){
            while(newCurr.next != null){
                // System.out.println(newCurr.val);
                newCurr = newCurr.next;
            }
            newCurr.next = list.get(i);
           
        }
        return res;
    }
}
