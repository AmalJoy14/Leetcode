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
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode currNode = head;
        while (currNode != null){
            currNode = currNode.next;
            size++;
        }
        
        currNode = head;
        int i = 1;
        while (i != size/2 + 1){
            currNode = currNode.next;
            i++;
        } 
        return currNode;
    }
}
