class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //Hard
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;
        for(int i = len ; i >= 0 ; i--){
            for(String str : wordDict){
                if(str.length() <= len - i && str.equals(s.substring(i, i + str.length())) && dp[i + str.length()] == true){
                    dp[i] = true;
                    break;
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
