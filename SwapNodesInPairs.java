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
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode currNode = head;
        ListNode nextNode = head.next;
        ListNode start = head;
        ListNode tail = head.next;

        head = head.next;
        
        while (start != null){
            currNode.next = null;

            if (nextNode == null){
                tail.next = currNode;
                tail = tail.next;
                break;
            }
            start = nextNode.next;
            nextNode.next = currNode;

            while(tail.next != null){
                tail = tail.next;
            }
            

            currNode = start;
            if (start != null){
                nextNode = start.next;
            }
            
            tail.next = nextNode;
        }
        tail.next = null;
        return head;
    }
}
