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
    List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        paths(root,"");
        return list;
    }

    public void paths(TreeNode root , String s){
        if (root == null){
            return;
        }
        s += root.val;
        if (root.left == null && root.right == null){
            list.add(s);
        }
        s += "->";
        paths(root.left, s);
        paths(root.right , s);
    }
}
