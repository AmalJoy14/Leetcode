/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        Queue<Node> que = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        Node[] arr = new Node[100];

        if (node == null) {
            return null;
        }

        que.add(node);
        while (!que.isEmpty()) {
            Node released = que.remove();
            visited.add(released.val);
            if (arr[released.val - 1] == null) {
                arr[released.val - 1] = new Node(released.val);
            }

            for (Node A : released.neighbors) {
                if (!visited.contains(A.val)) {
                    que.add(A);
                    visited.add(A.val);
                }
                if (arr[A.val - 1] == null) {
                    arr[A.val - 1] = new Node(A.val);
                }
                arr[released.val - 1].neighbors.add(arr[A.val - 1]);
                // System.out.println(arr[released.val -1].neighbors);
            }

        }
        return arr[0];
    }
}
