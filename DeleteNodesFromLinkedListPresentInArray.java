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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int e : nums){
            set.add(e);
        }
        ListNode curr = head;
        ListNode after = head.next;
        if (curr.next == null && set.contains(curr.val)) return null;

        while (after != null && set.contains(curr.val)){
            curr = after;
            after = after.next;
        }
        head = curr;

        while(after != null ){
            if (set.contains(after.val)){
                after = after.next;
            }
            else{
                curr.next = after;
                curr = after;
                after = after.next;
            }
        }
        curr.next = after;
        return head;
    }
}
