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
    boolean same = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        preorder(root, subRoot);
        return same;
    }
    
    public void preorder(TreeNode root, TreeNode subRoot) {
        if (root == null || same == true){
            return;
        }
        if (root.val == subRoot.val){
            boolean res = isSame(root, subRoot);
            if (res == true){
                same = true;
            }
        }
        isSubtree(root.left , subRoot);
        isSubtree(root.right , subRoot);
    }

    public boolean isSame(TreeNode root ,TreeNode subRoot){
        if (root == null && subRoot == null){
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val){
            return false;
        }
        return isSame(root.left,subRoot.left) && isSame(root.right, subRoot.right);

    }
}
