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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode evenHead = new ListNode();
        ListNode oddHead = new ListNode();
        ListNode oddP = oddHead, evenP = evenHead ;
        ListNode currNode = head , nextNode = head.next;
        int index = 1;
        while(currNode != null){
            if (index % 2 == 0){
                evenP.next = currNode;
                evenP = evenP.next;
            }
            else{
                oddP.next = currNode;
                oddP = oddP.next;
            }
            currNode.next = null;
            currNode = nextNode;
            if (nextNode != null){
                nextNode = nextNode.next;
            }
            index++;
        }
        oddP.next = evenHead.next;
        return oddHead.next;
    }
}
