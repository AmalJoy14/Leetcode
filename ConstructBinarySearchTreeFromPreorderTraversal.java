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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1 ; i < preorder.length ; i++){
            build(preorder[i] , root);
        }
        return root;
    }
    public TreeNode build(int val , TreeNode root){
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val < val){
            root.right = build(val , root.right);
        }
        else{
            root.left = build(val , root.left);
        }
        return root;
    }
}
