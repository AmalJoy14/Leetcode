/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = (nums.length - 1)/2;
        TreeNode root = new TreeNode(nums[mid]);
        buildTree(root , 0 , mid - 1 , nums);
        buildTree(root , mid + 1 , nums.length - 1 , nums);
        return root;
    }
    public void buildTree(TreeNode root , int start , int end, int[] nums){
        if(start > end){
            return;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        addNode(root, node);
        buildTree(root , start , mid - 1 , nums);
        buildTree(root , mid + 1 , end , nums);
    }

    public void addNode(TreeNode root, TreeNode node) {

        if (root.val < node.val && root.right == null) {
            root.right = node;
            return;
        }
        if (root.val > node.val && root.left == null) {
            root.left = node;
            return;
        }
        if (root.val < node.val) {
            addNode(root.right, node);
        } else {
            addNode(root.left, node);
        }
    }
}
