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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if (head == null || head.next == null || left == right){
            return head;
        }
        ListNode currNode = head;
        int pos = 1;
        while (currNode.next != null && pos < left-1){
            currNode = currNode.next;
            pos++;
        }
        ListNode start = currNode;
        while ( currNode.next != null && pos < left){
            currNode = currNode.next;
            pos++;
        }
        pos++;
        ListNode revEnd = currNode;
        ListNode nextNode = currNode.next;
        ListNode afterNode = nextNode.next;

        while(afterNode != null && pos < right){
            nextNode.next = currNode;
            currNode = nextNode;
            nextNode = afterNode;
            afterNode = afterNode.next;
            pos++;
        }
        ListNode end = nextNode.next;
        nextNode.next = currNode;
        ListNode revStart = nextNode;

        start.next = revStart;
        revEnd.next = end;
        if (left == 1){
            head = revStart;
        }
        return head;
    }
}
