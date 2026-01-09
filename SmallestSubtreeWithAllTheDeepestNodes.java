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
    TreeNode res = null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDepth = find(root);
        findSubtree(root , maxDepth , 1);
        return res;
    }
    public boolean findSubtree(TreeNode root , int max , int curr){
        if(root == null){
            return false;
        }
        if(curr == max){
            if(res == null) res = root;
            return true;
        }
        
        boolean left = findSubtree(root.left , max , curr + 1);
        boolean right = findSubtree(root.right , max , curr + 1);
        if(left && right){
            res = root;
        }
        return left || right; 
    }
    public int find(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = find(root.left);
        int right = find(root.right);

        return Math.max(left , right) + 1; 
    }
}
