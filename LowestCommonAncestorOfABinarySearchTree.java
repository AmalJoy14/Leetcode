/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode large, small;
        if (p.val > q.val){
            large = p;
            small = q;
        }
        else{
            large = q;
            small = p;
        }
        return lowestCommon(root , large, small);
    }
    public TreeNode lowestCommon(TreeNode root, TreeNode large, TreeNode small) {
        if (root.val <= large.val && root.val >= small.val){
            return root;
        }
        else if (root.val > large.val && root.val > small.val){
            return lowestCommon(root.left, large, small);
        }
        else {
            return lowestCommon(root.right, large, small);
        }
    }
}
