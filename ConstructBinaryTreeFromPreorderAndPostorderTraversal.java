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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder , postorder , new int[]{0} , new int[]{0});
    }
    public TreeNode build(int[] preorder , int[] postorder , int[] idx , int[] end){
        
        TreeNode root = new TreeNode(preorder[idx[0]]);
        idx[0]++;
        
        if(postorder[end[0]] != root.val){
            root.left = build(preorder , postorder , idx , end);
           
        }
        if(postorder[end[0]] != root.val){
            
            root.right = build(preorder , postorder , idx , end);
        }
        end[0]++;
        return root;
    }
}
