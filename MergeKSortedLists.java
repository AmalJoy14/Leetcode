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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (ListNode head : lists){
            while(head != null){
                pq.add(head.val);
                head = head.next;
            }
        }
        ListNode prev = null , curr = null; 
        while(!pq.isEmpty()){
            curr = new ListNode(pq.poll());
            curr.next = prev;
            prev = curr; 
        }
        return curr;
    }
}
