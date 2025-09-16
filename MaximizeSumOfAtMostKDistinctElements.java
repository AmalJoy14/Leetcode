class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : set){
            pq.add(num);
            if(pq.size() > k) pq.poll();
        }
        int[] res = new int[Math.min(k , pq.size())];
        int idx = res.length - 1;
        while(!pq.isEmpty() && k > 0){
            res[idx--] = pq.poll();
        }
        return res;
    }
}
