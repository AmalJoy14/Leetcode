class Solution {
    public long maxPower(int[] stations, int r, int k) {
        long total = 0 , res = 0;
        for(int station : stations){
            total += station;
        }
        long left = 0 , right = total + k;
        while(left <= right){
            long mid = left + (right - left) / 2;
            if(isPossible(mid , stations , r , k)){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
    public boolean isPossible(long mid , int[] stations , int r , int k){
        int n = stations.length;
        long sum = 0 , adder = 0;
        long[] done = new long[n];
        long[] prefixSum = new long[n + 1];
        for(int i = 0 ; i < n ; i++){
            sum += stations[i];
            prefixSum[i + 1] = sum;
        }
        for(int i = 0 ; i < n ; i++){
            adder -= done[i];
            int left = 0 , right = n;
            if(i - r > 0) left = i - r;
            if(i + r < n) right = i + r + 1;
            long val = prefixSum[right] - prefixSum[left];
            if(val + adder < mid){
                long req = mid - (val + adder);
                if(req > k) return false;
                adder += req;
                int idxStop = i + 2 * r + 1;
                if(idxStop < n) done[idxStop] = req;
                k -= req;
            }
        }
        return true;
    }
}
