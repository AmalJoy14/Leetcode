class Solution {
    public int waysToSplitArray(int[] nums) {
        int count = 0 , n = nums.length ;
        long sumLeft = 0 , sumRight = 0;
        
        for(int i = 0 ; i < n ; i++){
            sumRight += nums[i];
        }
        for(int i = 0 ; i < n - 1 ; i++){
            sumLeft += nums[i];
            sumRight -= nums[i];
            if(sumLeft >= sumRight){
                count++;
            }
        }
        return count;
    }
}
