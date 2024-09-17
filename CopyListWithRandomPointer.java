/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null){
            return null;
        }
        Node curr = head;
        Node newHead = new Node(head.val);
        Node curr2 = newHead;

        while(curr.next != null){
            curr = curr.next;
            Node a = new Node(curr.val);
            curr2.next = a;
            curr2 = curr2.next;
        }
        curr2.next = null;

        curr = head;
        curr2 = newHead;
        while(curr != null){
            Node loc = curr.random;
            int index = 1;
            Node start = head;
            while (start != loc){
                start = start.next;
                index++;
            }

            Node start2 = newHead;
            int index2 = 1;
            while(index2 != index){
                start2 = start2.next;
                index2++;
            }
            curr2.random = start2;
            curr = curr.next;
            curr2 = curr2.next;
        }
        return newHead;
    }
}
