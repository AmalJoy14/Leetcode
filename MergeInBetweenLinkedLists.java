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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        int pos = 0;
        while (pos != a-1){
            pos++;
            list1 = list1.next;
        }
        ListNode rmNode = list1.next;
        list1.next = list2;
        while (list1.next != null){
            list1 = list1.next;
        }
        while (pos != b){
            rmNode = rmNode.next;
            pos++;
        }
        list1.next = rmNode;
        return head;
    }
}
