/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        

        while (!que.isEmpty()) {
            que.add(null);
            long sum = 0;
            
            while (que.peek() != null) {
                
                TreeNode node = que.remove();
                sum += node.val;
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            que.remove();
            pq.add(sum);
            if (pq.size() > k){
                pq.poll();
            }
        }
        if (pq.size() == k){
            return pq.poll();
        }
        return -1;
    }
}
