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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = 0;
        if (head == null){
            return null;
        }
        ListNode currNode = head;
        while(currNode != null){
            currNode = currNode.next;
            sz++;
        }
        int pos = sz - n;
        if (pos == 0){
            return head.next;
        }
        currNode = head ;
        int currPos = 0;
        ListNode prevNode = new ListNode(0);
        prevNode.next = head;
        while(currNode != null && currPos != pos){
            currNode = currNode.next;
            prevNode = prevNode.next;
            currPos++;
        }
        prevNode.next = currNode.next;
        return head;
        
    }
}
