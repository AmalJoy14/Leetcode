class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : happiness){
            pq.add(num);
        }
        int sub = 0;
        while(k > 0){
            k--;
            int val = pq.poll() - sub;
            res += val > 0 ? val : 0;
            sub++;
        }
        return res;
    }
}
