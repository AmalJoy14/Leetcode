class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1 , right = ranks[0]*(long)cars*cars;
        while(left <= right){
            long mid = left + (right - left) / 2;
            long count = 0;
            for(int i = 0 ; i < ranks.length ; i++){
                count += (long)Math.sqrt(mid / (double)ranks[i]);
            }
            if(count >= cars){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return right + 1;
    }
}
