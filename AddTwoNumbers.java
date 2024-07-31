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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode();
        ListNode currNode = l3;
        ListNode a = l1;
        ListNode b = l2;
        int flag = 0 , newVal;
        while (a != null && b != null){
            newVal = flag == 1 ? 1 : 0 ;
            flag = 0;
            newVal += a.val+b.val;
            if (newVal > 9){
                flag = 1;
                newVal = newVal % 10;
            } else {
                flag = 0;
            }
            currNode.next = new ListNode(newVal);
            currNode = currNode.next;
            a = a.next;
            b = b.next;
        }

        while (a != null){
            newVal = flag == 1 ? 1 : 0 ;
            newVal += a.val;
            if (newVal > 9){
                flag = 1;
                newVal = newVal % 10;
            } else {
                flag = 0;
            }
            currNode.next = new ListNode(newVal);
            currNode = currNode.next;
            a = a.next;
        }
        
        while (b != null){
            newVal = flag == 1 ? 1 : 0 ;
            newVal += b.val;
            if (newVal > 9){
                flag = 1;
                newVal = newVal % 10;
            } else {
                flag = 0;
            }
            currNode.next = new ListNode(newVal);
            currNode = currNode.next;
            b = b.next;
        }
        if (flag == 1){
            currNode.next = new ListNode(1);
        }
        return l3.next;
    }
}
