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
    public int getDecimalValue(ListNode head) {
        int num = 0,size = 1;
        ListNode currNode = head;
        while (currNode.next != null){
            size++;
            currNode = currNode.next;
        }
       
        currNode = head;
        while (currNode != null){
            if (currNode.val == 1){
                num = num + (int)Math.pow(2 , size - 1);
            }
            currNode = currNode.next;
            size--;
        }
        return num;
    }
}
