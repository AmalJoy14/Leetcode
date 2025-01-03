class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int idx1 = text1.length() , idx2 = text2.length();
        int[][] dp = new int[idx1 + 1][idx2 + 1];

        for (int i = 1 ; i <= idx1 ; i++){
            for (int j = 1 ; j <= idx2 ; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max( dp[i][j - 1] , dp[i - 1][j]);
                }
            }
        }
        return dp[idx1][idx2];
    }
}
