class Solution {
    public long maxAlternatingSum(int[] nums) {
        long res = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            if(num < 0){
                num = -num;
            }
            pq.add((long)num);
        }
        int n = nums.length;
        int pos = n / 2 + n % 2;
        while(pos != 0){
            res += Math.pow(pq.poll() , 2);
            pos--;
        }
        while(!pq.isEmpty()){
            res -= Math.pow(pq.poll() , 2);
        }
        return res;
    }
}
