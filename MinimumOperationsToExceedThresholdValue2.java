class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            pq.add((long)nums[i]);
        }
        int op = 0;
        while(pq.peek() < k && pq.size() >= 2){
            long x = pq.poll();
            long y = pq.poll();
            pq.add(Math.min(x , y) * 2 + Math.max(x , y));
            op++;
        }
        return op;
    }
}
