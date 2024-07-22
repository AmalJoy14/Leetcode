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
    public ListNode mergeNodes(ListNode head) {
        ListNode currNode = head.next;
        ListNode newHead = new ListNode(0);
        ListNode currNode2 = newHead;
        int sum = 0;
        while(currNode != null){
            sum +=currNode.val;
            if (currNode.val == 0){
                currNode2.next = new ListNode(sum);
                currNode2 = currNode2.next;
                sum = 0;
            } 
            currNode = currNode.next;
        }
        return newHead.next;
    }
}
