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
    public int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        findH(root);
        return max; 
    }
    public int findH(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = findH(root.left);
        int right = findH(root.right);

        max =  Math.max(max, left + right);


        return 1 + Math.max(left ,right);
    }
}
