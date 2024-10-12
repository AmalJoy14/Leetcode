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
    long prev ,curr = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {

        //Inorder Traversal results in sorted values in BST.
        if (root == null){
            return true;
        }
        boolean left = isValidBST(root.left);
        prev = curr;
        curr = root.val;
        if (prev >= curr){
            return false;
        }
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
