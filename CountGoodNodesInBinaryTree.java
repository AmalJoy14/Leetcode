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
    int count = 0;
    Stack<Integer> stk = new Stack<>();
    public int goodNodes(TreeNode root) {
        stk.push(Integer.MIN_VALUE);
        preorder(root);
        return count;
    }

    public void preorder(TreeNode root){
        if (root == null){
            return;
        }
        if (root.val >= stk.peek()){
            stk.push(root.val);
            count++;
        }
        preorder(root.left);
        if (root.left != null){
            if (stk.peek() == root.left.val){
                stk.pop();
            }
        }
        
        preorder(root.right);
        if (root.right != null){
            if (stk.peek() == root.right.val){
                stk.pop();
            }
        }

    }
}
