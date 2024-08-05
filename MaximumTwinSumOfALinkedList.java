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
    public int pairSum(ListNode head) {
        int max = 0;
        ListNode curr = head, after = head, prev = new ListNode(0);
        prev.next = head;
        while (after != null){
            prev = prev.next;
            curr = curr.next;
            after = after.next.next;
        }
        prev.next = null;
        prev = null;
        after = null;
        while (curr != null){
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        curr = head;
        while(curr != null){
            if (prev.val + curr.val > max){
                max = prev.val + curr.val;
            }
            prev = prev.next;
            curr = curr.next;
        }
        return max;
    }
}
