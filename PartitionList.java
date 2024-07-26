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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode newHead = new ListNode(-404);
        ListNode newCurrNode = newHead;
        ListNode currNode = head;
        int flag = 0;
        ListNode jump = null;
        ListNode prevNode = new ListNode(-404);
        prevNode.next = head;

        while(currNode != null){
            if  (currNode.val >= x){
                newCurrNode.next = new ListNode(currNode.val);
                newCurrNode = newCurrNode.next;
                if (flag == 0 ){
                    jump = prevNode;
                    flag = 1;
                }
                prevNode = currNode;
                currNode = currNode.next;
                continue;
            }
            if (jump != null && jump.val == -404){
                head = currNode;
                jump = null;
            }
            if (jump != null){
                jump.next = currNode;
                jump = null;
            }
            prevNode = currNode;
            currNode = currNode.next;
            flag = 0;
        }
        if(currNode == null && jump != null){
             prevNode = jump;
            jump.next = currNode;
        }
    
        prevNode.next = newHead.next;
        return head;
    }
}
