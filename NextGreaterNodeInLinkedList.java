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
    public int[] nextLargerNodes(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode curr = head;
        int size = 1, k = 0;
        while (curr.next != null){
            size++;
            curr = curr.next;
        }
        curr.next = new ListNode(0);
        curr = head;
        int []arr = new int[size];
        while (curr.next != null){
            ListNode after = curr.next;
            while(after.next != null && after.val <= curr.val){
                after = after.next;
            }
            arr[k++] = after.val;
            curr = curr.next;
        }
        return arr;
    }
}
