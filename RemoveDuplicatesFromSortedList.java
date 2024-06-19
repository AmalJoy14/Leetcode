/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode currNode = head;

        if (currNode == null || currNode.next == null) {
            return currNode;
        }
        ListNode nextNode = currNode.next;
        
        while (nextNode != null) {
            if (currNode.val == nextNode.val) {
                currNode.next = nextNode.next;
                nextNode = nextNode.next;
            } else {
                currNode = currNode.next;
                nextNode = nextNode.next;
            }
        }
        return head;
    }
}
