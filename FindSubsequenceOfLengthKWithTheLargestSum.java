class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0] , b[0]));
        for(int i = 0 ; i < nums.length ; i++){
            pq.add(new int[]{nums[i] , i});
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a,b) -> Integer.compare(a[1] , b[1]));
        while(!pq.isEmpty()){
            pq2.add(pq.poll());
        }
        int idx = 0;
        while(!pq2.isEmpty()){
            res[idx] = pq2.poll()[0];
            idx++;
        }
        return res;
    }
}
