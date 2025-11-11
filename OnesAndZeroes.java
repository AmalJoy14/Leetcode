class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] zeroArr = new int[len];
        int[] oneArr = new int[len];
        for(int i = 0 ; i < len ; i++){
            int zero = 0;
            int one = 0;
            String str = strs[i];
            for(int j = 0 ; j < str.length() ;j++){
                if(str.charAt(j) == '0') zero++;
                else one++;
            }
            zeroArr[i] = zero;
            oneArr[i] = one;
        }
        int[][][] dp = new int[len][m + 1][n + 1];
        for(int[][] mat : dp){
            for(int[] arr : mat){
                Arrays.fill(arr, -1);
            }
        }
        return findMax(zeroArr , oneArr , 0 , m , n , dp);
    }
    public int findMax(int[] zeroArr , int[] oneArr , int idx ,int m , int n ,int[][][] dp){
        if(idx >= oneArr.length){
            return 0;
        }
        if(dp[idx][m][n] != -1){
            return dp[idx][m][n];
        }
        int take = 0 , nottake = 0;
        nottake = findMax(zeroArr ,oneArr , idx + 1 , m , n , dp);
        if(m >= zeroArr[idx] && n >= oneArr[idx]){
            take = findMax(zeroArr ,oneArr ,idx + 1 , m - zeroArr[idx] , n - oneArr[idx] , dp) + 1;
        }
        return dp[idx][m][n] = Math.max(take , nottake);
    }
}
