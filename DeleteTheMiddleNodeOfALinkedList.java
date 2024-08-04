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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        int size = 0, pos = 0;
        ListNode curr = head;
        while(curr.next != null){
            size++;
            curr = curr.next;
        }
        curr = head;
        while (curr != null && pos != (size-1)/2){
            curr = curr.next;
            pos++;
        }
        if (curr != null && curr.next != null){
            curr.next = curr.next.next;
        }
        
        return head;
    }
}
