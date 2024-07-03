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
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;    // An empty list or single-node list is considered a palindrome
        }

        StringBuilder sb = new StringBuilder();
        ListNode currNode = head ;
        while (currNode.next != null){
            sb.append(String.valueOf(currNode.val));
            currNode = currNode.next;
        }
        sb.append(String.valueOf(currNode.val));
        String ssb = String.valueOf(sb);
        String rsb = String.valueOf(sb.reverse());
        return ssb.equals(rsb);
    }
}
