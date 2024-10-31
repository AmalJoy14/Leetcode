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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left == null && root.right == null){
            return 0;
        }
        sumOf(root);
        return sum;
    }
    public int sumOf(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return root.val;
        }
        int left = sumOf(root.left);
        sumOf(root.right);
        // System.out.println(left);
        sum += left;
        return 0;
    }
}
