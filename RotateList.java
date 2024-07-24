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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode currNode = head;
        int size = 1 , pos = 0;
        while(currNode.next != null){
            size++;
            currNode = currNode.next;
        }
        if ( k % size == 0){
            return head;
        }

        int cut =size - k % size;

        currNode = head;
        while ( currNode.next != null && pos < cut -1 ){
            pos++;
            currNode = currNode.next;
        }
        ListNode newHead = currNode.next;
        currNode.next = null;
        currNode = newHead;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = head;
        return newHead;
    }
}
