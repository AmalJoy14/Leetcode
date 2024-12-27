class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if(s.charAt(0) == '0') return 0;

        int flag = 0;
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 1; i < s.length() ; i++){
            int val = Integer.parseInt(s.substring(i - 1, i + 1));
            flag = 0;

            if(s.charAt(i) >= '1' && s.charAt(i) <= '9'){    //Single digit valid
                dp[i + 1] += dp[i];
                flag++;
            } 
            if(val >= 10 && val <= 26){                //Two digit valid
                dp[i + 1] += dp[i - 1];
                flag++;
            }
            if(flag == 0){
                return 0;
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
}
