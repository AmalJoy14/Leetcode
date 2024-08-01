/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode hare = head;
        ListNode turtle = head;
        ListNode meetPoint;
        while (hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
            if (hare == turtle){
                hare = head;
                while (hare != turtle){
                    hare = hare.next;
                    turtle = turtle.next;
                }
                return hare; //or turtle
            }
        }
        return null;
    }
}
