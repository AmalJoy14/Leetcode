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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode currNode = new ListNode(-1);
        ListNode newHead = currNode;
        currNode.next = head;
        ListNode nextNode = head;

        while (nextNode != null){
            if (nextNode.val == val){
                currNode.next = nextNode.next;
                nextNode = nextNode.next;
                
                continue;
            }
            currNode = nextNode;
            nextNode = nextNode.next;
        }
        return newHead.next;
    }
}
