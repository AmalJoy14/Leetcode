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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode();
        ListNode currNode = list3;

        while (list1 != null && list2 != null) {
            ListNode temp;
            if (list1.val >= list2.val) {
                temp = new ListNode(list2.val, null);
                list2 = list2.next;
            }
            else {
                temp = new ListNode(list1.val, null);
                list1 = list1.next;
            }
            currNode.next = temp;
            currNode = currNode.next;
        }

        while (list1 != null) {
            ListNode temp = new ListNode(list1.val, null);
            currNode.next = temp;
            currNode = currNode.next;

            list1 = list1.next;
        }

        while (list2 != null) {
            ListNode temp = new ListNode(list2.val, null);
            currNode.next = temp;
            currNode = currNode.next;

            list2 = list2.next;
        }
        return list3.next;
    }
}
