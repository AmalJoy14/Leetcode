class Solution {
    public int numSquares(int n) {
        int[] arr = new int[100];
        for(int i = 1 ; i <= 100 ; i++){
            arr[i - 1] = i * i;
        }
        int[][] dp = new int[100][n + 1];
        for(int[] num : dp){
            Arrays.fill(num , -1);
        }
        return findMin(arr ,99 , n , dp);
    }
    public int findMin(int[] arr ,int idx ,int n , int[][] dp){
        if(idx < 0 || n < 0){
            return 999999;
        }
        if(n == 0) return 0;
        if(dp[idx][n] != -1){
            return dp[idx][n];
        }
        int take = findMin(arr ,idx , n - arr[idx] ,dp) + 1;
        int nottake = findMin(arr , idx - 1 , n, dp);
        return dp[idx][n] = Math.min(take , nottake);
    }
}
