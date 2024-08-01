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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Reverse the 2 linked lists
        ListNode prev = null, curr = l1 , after = l1.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = after;
            if (after != null){
                after = after.next;
            } 
        }
        l1 = prev;

        prev = null;
        curr = l2 ;
        after = l2.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = after;
            if (after != null){
                after = after.next;
            } 
        }
        l2 = prev;
        

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
        prev = null;
        curr = l3.next ;
        after = l3.next.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = after;
            if (after != null){
                after = after.next;
            } 
        }
        l3 = prev;
        return l3;
    }
}
