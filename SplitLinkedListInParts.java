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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] list = new ListNode[k];
        if (head == null){
            return list;
        }
        

        ListNode curr = head;
        int size = 0, i = 0;
        while (curr != null){
            size++;
            curr = curr.next;
        }
        int num , rem,empty = 0;
        if(size < k){
            num = 1;
            rem = 0;
            empty = k - size;
        } else{
            rem = size % k;
            num = size / k;
        }
        if (empty > 0){
            ListNode prevN = head, currN = head.next;
            while(currN != null){
                prevN.next = null;
                list[i] = prevN;
                i++;
                prevN = currN;
                currN = currN.next;
            }
            list[i] = prevN;
            return list;
        }

        curr = head;
        
        ListNode subHead;
        while(curr != null){
            int index = 0;
            subHead = curr;
            while(index < num - 1){
                curr = curr.next;
                index++;
            }
            if(rem != 0){
                rem--;
                curr = curr.next;
            }
            ListNode prev = curr;
            curr = curr.next;
            prev.next = null;
           
            list[i] = subHead;
            i++;
        }

        return list;
    }
}
