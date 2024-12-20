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
    public TreeNode reverseOddLevels(TreeNode root) {
        reverse(root.right, root.left, false);
        return root;
    }

    public void reverse(TreeNode rootLeft, TreeNode rootRight, boolean flag) {
        if (rootLeft == null || rootRight == null) {
            return;
        }
        flag = !flag;
        if (flag == true) {

            int temp = rootLeft.val;
            rootLeft.val = rootRight.val;
            rootRight.val = temp;

        }
        reverse(rootLeft.left, rootRight.right, flag);
        reverse(rootLeft.right, rootRight.left, flag);
    }
}
