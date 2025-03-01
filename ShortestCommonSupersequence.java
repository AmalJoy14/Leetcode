class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }
        findShortest(str1 , str2 , 0 , 0 , dp);
        // System.out.println(Arrays.deepToString(dp));
        return constructSCS(str1, str2, dp);
    }

    public int findShortest(String str1 , String str2 , int i , int j , int[][] dp){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == str1.length() && j == str2.length()){
            dp[i][j] = 0;
            return 0;
        }
        if(i == str1.length()){
            dp[i][j] = 1 + findShortest(str1 , str2 , i , j + 1 , dp);
            return dp[i][j];
        }
        if(j == str2.length()){
            dp[i][j] = 1 + findShortest(str1 , str2 , i + 1 , j , dp);
            return dp[i][j];
        }

        if(str1.charAt(i) == str2.charAt(j)){
            dp[i][j] =  1 + findShortest(str1 , str2 , i + 1 , j + 1 , dp);
            return dp[i][j];
        }
        else {
            int a = 1 + findShortest(str1 , str2 , i + 1 , j , dp);
            int b = 1 + findShortest(str1 , str2 , i , j + 1, dp);
            dp[i][j] = a < b ? a : b ;
            return dp[i][j];
        }
    }
    private String constructSCS(String str1, String str2, int[][] dp) {
        StringBuilder scs = new StringBuilder();
        int i = 0, j = 0;
        
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                scs.append(str1.charAt(i));
                i++;
                j++;
            } else if (dp[i + 1][j] < dp[i][j + 1]) {
                scs.append(str1.charAt(i));
                i++;
            } else {
                scs.append(str2.charAt(j));
                j++;
            }
        }

        // Append remaining characters from either string
        while (i < str1.length()) scs.append(str1.charAt(i++));
        while (j < str2.length()) scs.append(str2.charAt(j++));

        return scs.toString();
    }
}
