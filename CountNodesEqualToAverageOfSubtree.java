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
class Pair{
    int sum ;
    int count;
    Pair(int sum , int count){
        this.sum = sum;
        this.count = count;
    }
}
class Solution {
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        averageCount(root );
        return res;
    }
    public Pair averageCount(TreeNode root){
        if(root == null){
            return new Pair(0 , 0);
        }
        
        Pair left = averageCount(root.left);
        Pair right = averageCount(root.right);
        int divider = left.count + right.count + 1;
        int sum = left.sum + right.sum + root.val;
        if( sum/ divider == root.val){
            res++;
        }
        return new Pair(sum , divider);
    }
}
