class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        int[][] dp = new int[nums.size()][nums.size()];
        return splitArray(nums , 0 , nums.size() - 1 , m , dp);
    }

    public boolean splitArray(List<Integer> nums , int start , int end , int m , int[][] dp){
        if(dp[start][end] == 1){
            return true;
        }
        if(dp[start][end] == -1){
            return false;
        }
        int sum = 0;
        for(int i = start ; i <= end ; i++){
            sum += nums.get(i);
        }
        
        if(start == end){
            dp[start][end] = 1;
            return true;
        }
        if((start != 0 || end != nums.size() - 1) && sum < m){
            dp[start][end] = -1;
            return false;
        }
        boolean left = false , right = false;
        for(int k = start ; k < end ; k++){
            left = splitArray(nums , start , k  , m , dp);
            right = splitArray(nums , k + 1  , end , m , dp);
            if(left && right){
                dp[start][end] = 1;
                return true;
            }
        }
        dp[start][end] = -1;
        return false;
    }
}
