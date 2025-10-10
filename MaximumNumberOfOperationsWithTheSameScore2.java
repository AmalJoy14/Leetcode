class Solution {
    public int maxOperations(int[] nums) {
        int left = 0 , right = nums.length - 1;
        int res = 0;
        int[][][] dp = new int[right + 1][right + 1][3];
        for(int[][] mat : dp){
            for(int[] arr : mat){
                Arrays.fill(arr , -1);
            }
        }
        res = Math.max(res , findMax(nums ,2 , right , nums[0] + nums[1] , 0 , dp) + 1);
        res = Math.max(res , findMax(nums ,0 , right - 2 , nums[right] + nums[right - 1] , 1 , dp) + 1);
        res = Math.max(res , findMax(nums ,1 , right - 1 , nums[0] + nums[right] , 2 , dp) + 1);
        return res;
    }
    public int findMax(int[] nums ,int left , int right , int sum , int ord , int[][][] dp){
        if(left >= right){
            return 0;
        }
        if(dp[left][right][ord] != -1){
            return dp[left][right][ord];
        }
        //System.out.println(left + " " + right);
        int opt1 = 0 , opt2 = 0 , opt3 = 0;
        if(nums[left] + nums[left + 1] == sum){
            opt1 = findMax(nums ,left + 2 , right , sum , ord , dp) + 1;
        }
        if(nums[right] + nums[right - 1] == sum){
            opt2 = findMax(nums , left ,right - 2 , sum , ord , dp) + 1;
        }
        if(nums[left] + nums[right] == sum){
            opt3 = findMax(nums , left + 1 ,right - 1 , sum ,ord , dp) + 1;
        }
        return dp[left][right][ord] = Math.max(opt1 , Math.max(opt2 , opt3));
    }
}
