/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode res;
    int found = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommon(root, p , q);
        return res;
    }
    public boolean lowestCommon(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return false;
        }
        if (found == 0 && (root == p || root == q)){
            res = root;
            found = 1;
        }
        if (found == 1 && (root == p || root == q)){
            return true;
        }
        boolean left = lowestCommon(root.left, p , q);
        boolean right = lowestCommon(root.right, p , q);

        if (left == true && right == true){
            res = root;
        }
        if ((right == true || left == true) && (root.val == p.val || root.val == q.val)){
            res = root;
        }
        return right || left;
    }
}
