class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i] , i);
        }
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int[] num : dp){
            Arrays.fill(num , -1);
        }
        int res = 0;
        for(int i = 0; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                res = Math.max(findLong(arr , i , j ,map , dp)  , res);
            }
        }
        return res <= 2 ? 0 : res;
    }
    public int findLong(int[] arr , int i , int j , HashMap<Integer , Integer> map , int[][] dp){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(!map.containsKey(arr[i] + arr[j])){
            dp[i][j] = 2;
            return 2;
        }
        dp[i][j] = findLong(arr , j , map.get(arr[i] + arr[j]) , map , dp) + 1;
        return dp[i][j];
    }
}
