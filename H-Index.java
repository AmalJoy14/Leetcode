class Solution {
    public int hIndex(int[] citations) {
        int left = 0 , right = 1000, res = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            if(isPossible(mid , citations)){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
    public boolean isPossible(int mid , int[] citations){
        int count = 0;
        for(int i = 0 ; i < citations.length ; i++){
            if(citations[i] >= mid) count++;
        }
        return count >= mid;
    }
}
