class Solution {
    public int numDistinct(String s, String t) {
        int i = s.length() - 1 , j = t.length() - 1;
        if(i < j) return 0;
        int[][] dp = new int[i + 1][j + 1];
        for(int[] num : dp){
            Arrays.fill(num , -1);
        }
        return findCount(i , s , j , t , dp);
    }
    public int findCount(int i , String s , int j , String t , int[][] dp){
        if(j < 0){
            return 1;
        }
        if(i < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        char ch1 = s.charAt(i) , ch2 = t.charAt(j);
        int take = 0 , nottake = 0;

        if(ch1 == ch2){
            take = findCount(i - 1 , s , j - 1 , t , dp);
        }
        nottake = findCount(i - 1 , s , j , t , dp);

        return dp[i][j] = take + nottake;
    }
}
