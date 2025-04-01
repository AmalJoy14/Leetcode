class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp , -1);
        findMax(questions , dp , 0);
        return dp[0];
    }
    public long findMax(int[][] questions , long[] dp , int i){
        if(i >= questions.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        long val1 = questions[i][0] + findMax(questions , dp , i + questions[i][1] + 1);
        long val2 = findMax(questions , dp , i + 1);
         
        dp[i] = Math.max(val1 , val2);
        return dp[i];
    }
}
