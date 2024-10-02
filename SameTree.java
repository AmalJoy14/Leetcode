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
    public void preorder(TreeNode n, List<Integer> list){
        if (n == null){
            list.add(null);
            return;
        }
        list.add(n.val);
        preorder(n.left, list);
        preorder(n.right, list);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        preorder(p, list1);
        preorder(q, list2);
        // System.out.println(list1 +"\n" + list2);
        return list1.equals(list2);
    }
}
