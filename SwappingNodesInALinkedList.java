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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        int size = 0;
        ListNode curr = head,pointer = null;
        while (curr != null){
            size++;
            curr = curr.next;
        }
        int rem = size - k + 1;
        if (rem < k){
            rem = rem ^ k;
            k = rem ^ k;
            rem = rem ^ k;
        }
        curr = head;
        int pos = 1;
        while (curr != null && pos < rem){
            if(pos == k){
                pointer = curr;
            }
            pos++;
            curr = curr.next;
        }
        if (pointer == null){
            return head;
        }
        int temp = pointer.val;
        pointer.val = curr.val;
        curr.val = temp;
        return head;
    }
}
