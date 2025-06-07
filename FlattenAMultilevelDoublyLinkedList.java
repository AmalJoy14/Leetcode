/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        traverse(head);
        return head;
    }
    public Node traverse(Node node){
        Node prev = null;
        while (node != null){
            if(node.child != null){
                Node nxt = node.next;
                Node childNode = node.child;
                node.child = null;
                node.next = childNode;
                childNode.prev = node;
                if(nxt != null){
                    Node ret = traverse(childNode);
                    nxt.prev = ret;
                    nxt.prev.next = nxt;
                }
            }
            prev = node;
            node = node.next;
        }
        return prev;
    }
}
