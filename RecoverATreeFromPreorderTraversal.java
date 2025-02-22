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
    public TreeNode recoverFromPreorder(String traversal) {
        return createBT(traversal , new int[]{0} ,new int[]{0}, 0 );
    }

    public TreeNode createBT(String traversal , int[] idx ,int[] newDepth ,int depth ){
        if(idx[0] == traversal.length()){
            return null;
        }

        int j = idx[0];
        while(j < traversal.length() && traversal.charAt(j) != '-'){
            j++;
        }
        int num = Integer.parseInt(traversal.substring(idx[0] , j));
        TreeNode root = new TreeNode(num);
        idx[0] = j;


        int k = idx[0];
        int nextDepth = 0;
        while(k < traversal.length() && traversal.charAt(k) == '-'){
            k++;
            nextDepth++;
        }
        idx[0] = k;
        newDepth[0] = nextDepth;

        if(depth + 1 == nextDepth)
            root.left = createBT(traversal , idx ,newDepth , nextDepth );
        if(depth >= newDepth[0])
            return root;
        root.right = createBT(traversal , idx ,newDepth , nextDepth );

        return root;
    }
}
