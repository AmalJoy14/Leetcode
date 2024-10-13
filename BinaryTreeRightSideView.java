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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        if (root == null) return list;

        que.add(root);
        list.add(root.val);

        
        while(!que.isEmpty()){
            TreeNode temp = que.remove();
            que.add(null);
            int done = 0;
            while (temp != null){
                
                TreeNode right = temp.right;
                if (right != null){
                    que.add(temp.right);
                    if (done == 0){
                        list.add(temp.right.val);
                        done = 1;
                    }
                }

                TreeNode left = temp.left;
                if (left != null){
                    que.add(temp.left);
                    if (done == 0){
                        list.add(temp.left.val);
                        done = 1;
                    }
                }
                temp = que.remove();
            
            }
            

        }
        return list;
    }
}
