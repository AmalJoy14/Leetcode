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
    int loc = 0,res = 0;
    public int kthSmallest(TreeNode root, int k) {
        //Inorder Traversal of BST is sorted.
        if (root == null){
            return res;
        }
        kthSmallest(root.left, k);
        loc++;
        if (loc == k){
            res = root.val;
        }
        kthSmallest(root.right, k);
        return res;
    }
}
