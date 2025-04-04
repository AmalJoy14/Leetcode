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
    TreeNode lca = null;
    int flag = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth = findDepth(root);
        // System.out.println(maxDepth);
        
        findLCA(root , maxDepth , 1);
        return lca;
    }
    public boolean findLCA(TreeNode root , int maxDepth , int curr ){
        if(root == null){
            return false;
        }
        if(curr == maxDepth){
            if(flag == 0){
                flag = 1;
                lca = root;
            }
            return true;
        }
        boolean left = findLCA(root.left , maxDepth , curr + 1);
        boolean right = findLCA(root.right , maxDepth , curr + 1 );
        if(left && right){
            lca = root;
        }
        return left || right;
    }
    public int findDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        return 1 + Math.max(left , right);
    }
}
