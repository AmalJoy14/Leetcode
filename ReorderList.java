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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }

        ListNode currNode = head;
        int size = 1, halfSize;

        while (currNode.next != null){
            size++;
            currNode = currNode.next;
        }
        halfSize = size/2 ;
        if (size%2 != 0){
            halfSize++;
        }
        int pos = 1;
        currNode = head;
        while (currNode.next != null && pos != halfSize){
            pos++;
            currNode = currNode.next;
        }
        ListNode tail = currNode;
        currNode = currNode.next;
        tail.next = null;

        ListNode prevNode = null ,nextNode = currNode.next;

        while ( nextNode != null){
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;
        }
        currNode.next = prevNode;
        ListNode revHead = currNode;
        
        currNode = head;
        ListNode newCurrNode = revHead;
        ListNode newNextNode = newCurrNode.next;
        while (currNode.next != null){
            newCurrNode.next = currNode.next;
            currNode.next = newCurrNode;
            

            currNode = currNode.next.next;
            newCurrNode = newNextNode;
            if (newNextNode != null){
                newNextNode = newNextNode.next;
            }
        }
        if (newCurrNode != null){
            currNode.next = newCurrNode;
        }
    }
}
