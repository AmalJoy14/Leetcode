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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode newHead = head;
        ListNode curr = head;
        ListNode after = head.next;
        while(after != null){
            int min = Math.min(curr.val, after.val);
            int max = Math.max(curr.val, after.val);
            ListNode n = new ListNode(gcd(min , max));
            curr.next = n;
            n.next = after;
            curr = after;
            after = after.next;
        }
        return newHead;
    }
    public int gcd(int min , int max){
        if(min == 0){
            return max;
        }
        return gcd( max % min, min);
    }
}
