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
    int min = -1;
    public int minDepth(TreeNode root) {
        findMin( root, 1);
        if (min == -1){
            return 0;
        }
        return min;
    }
    public void findMin(TreeNode root, int depth){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            if (min == -1){
                min = depth;
            }
            else{
                min = Math.min(depth,min);
            }
        }
        depth++;
        findMin(root.left , depth);
        findMin(root.right , depth);
    }
}
