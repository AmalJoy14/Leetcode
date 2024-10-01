/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode end = new TreeNode(44044);

        que.add(root);
        que.add(end);
        while(que.size() != 1){
            List<Integer> sub = new ArrayList<>();
            while(que.peek() != end){
                TreeNode node = que.remove();
                if (node == null)
                    continue;
                sub.add(node.val);
                que.add(node.left);
                que.add(node.right);
            }
            que.remove();
            que.add(end);
            if (!sub.isEmpty())
                list.add(sub);
        }
        return list;
    }
}
