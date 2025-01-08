class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(),n = s2.length();
        int[][] dp = new int[m + 1][n+1];

        for(int i = 1 ; i <= m; i++){
            for(int j = 1 ; j <= n ; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] =  (int)s1.charAt(i - 1) + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1] , dp[i -1][j]);
                }
            }
        }
        // System.out.println(dp[m][n]);
        int res = 0;
        for(int k = 0 ; k < s1.length() ; k++){
            res += s1.charAt(k);
        }
        for(int k = 0 ; k < s2.length() ; k++){
            res += s2.charAt(k);
        }
        return res - 2 * dp[m][n]; 
    }
}
