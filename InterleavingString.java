class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length() , n2 = s2.length() , n3 = s3.length();
        Boolean[][][] dp = new Boolean[n1 + 1][n2 + 1][n3 + 1];

        return isPossible(0 , s1 , 0 , s2 , 0 , s3 , dp);
    }

    public boolean isPossible(int i , String s1 , int j , String s2 , int k , String s3 , Boolean[][][] dp){
        int n1 = s1.length() , n2 = s2.length() , n3 = s3.length();
        if(k >= n3 && i >= n1 && j >= n2){
            return true;
        }
        if(i >= n1 && j >= n2){
            return false;
        }
        if(dp[i][j][k] != null){
            return dp[i][j][k];
        }
        boolean equal1 = false , equal2 = false;
        boolean case1 = i < n1 && k < n3 && s1.charAt(i) == s3.charAt(k);
        boolean case2 = j < n2 && k < n3 && s2.charAt(j) == s3.charAt(k);
        if(case1 || case2 ){
            if( case1 )
                equal1 = isPossible(i + 1 , s1 , j , s2 , k + 1 , s3 , dp);
            if( case2 )
                equal2 = isPossible(i , s1 , j + 1 , s2 , k + 1 , s3 , dp);
        }
        return dp[i][j][k] = equal1 || equal2 ;
    }
}
