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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        else if (root.val > key){
            root.left = deleteNode(root.left , key);
        }
        else if (root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else if (root.val == key){

            //Case 1
            if (root.left == null && root.right == null){
                return null;
            }

            //Case 2
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }

            //Case 3
            TreeNode inorderSuccessor = inorderSuccessor(root.right);
            // System.out.println(inorderSuccessor.val);
            deleteNode(root , inorderSuccessor.val);
            root.val = inorderSuccessor.val;
        }

        return root;
    }
    public TreeNode inorderSuccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
