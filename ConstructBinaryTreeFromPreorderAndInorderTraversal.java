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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        List<Integer> pre = new ArrayList<>();
        for (int e : preorder){
            pre.add(e);
        }
        List<Integer> in = new ArrayList<>();
        for (int e : inorder){
            in.add(e);
        }
        return build(pre, in);
    }

    public TreeNode build(List<Integer> pre, List<Integer> in){
        if (in.isEmpty() || pre.isEmpty()){
            return null;
        }
        int mid = in.indexOf(pre.get(0));
        TreeNode root = new TreeNode(pre.remove(0));
        
        List<Integer> leftInorder = new ArrayList<>();
        for (int i = 0 ; i < mid ; i ++){
            leftInorder.add(in.get(i));
        }
        List<Integer> rightInorder = new ArrayList<>();
        for (int i = mid + 1 ; i < in.size() ; i ++){
            rightInorder.add(in.get(i));
        }
        
        in.remove(mid);

        root.left = build(pre, leftInorder);
        root.right = build(pre,rightInorder);
        return root;
    }
}
