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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode curr = new TreeNode(val , root , null);
            return curr;
        }
        attachNodes(root , val , depth , 2);
        return root;
    }
    public void attachNodes(TreeNode root ,int val ,int depth ,int currDepth){
        if(root == null){
            return;
        }
        if(currDepth == depth){
            TreeNode newNode1 = new TreeNode(val);
            newNode1.left = root.left;
            root.left = newNode1;
            TreeNode newNode2 = new TreeNode(val);
            newNode2.right = root.right;
            root.right = newNode2;
            return;
        }
        attachNodes(root.left , val , depth , currDepth + 1);
        attachNodes(root.right , val , depth , currDepth + 1);
    }
}
