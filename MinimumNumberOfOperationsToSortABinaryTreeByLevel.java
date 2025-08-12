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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        que.add(root);
        que.add(null);
        List<Integer> pq = new ArrayList<>();

        while(!que.isEmpty()) {
            TreeNode curr = que.remove();
            if(curr != null){
                pq.add(curr.val);
                TreeNode left = curr.left;
                if(left != null) que.add(left);
                TreeNode right = curr.right;
                if(right != null) que.add(right);
            }
            else{
                list.add(new ArrayList<>(pq));
                pq.clear();
                if(que.isEmpty()) break;
                que.add(null);
                
            }
        }
        System.out.println(list);
        int count = 0;
        int[] idx = new int[100001];
        Arrays.fill(idx , -1);
        for(int i = 0 ; i < list.size() ; i++){
            List<Integer> sub = list.get(i);
            PriorityQueue<Integer> subpq = new PriorityQueue<>();
            for(int j = 0 ; j < sub.size() ; j++){
                subpq.add(sub.get(j));
                idx[sub.get(j)] = j;
            }
            for(int j = 0 ; j < sub.size() ; j++){
                int min = subpq.poll();
                if(sub.get(j) != min){
                    //System.out.println(sub.get(j) + " " + arr[0]);
                    count++;
                    int getIdx = idx[min];
                    sub.set(idx[min] , sub.get(j));
                    idx[sub.get(j)] = getIdx; 
                    //System.out.println(sub);
                }
            }
        }
        return count;
    }
}
