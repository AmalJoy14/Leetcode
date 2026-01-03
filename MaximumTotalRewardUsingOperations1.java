class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int[][] dp = new int[rewardValues.length][4000];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }
        return findMax(rewardValues , 0 , 0 , dp);
    }
    public int findMax(int[] rewards , int i , int sum , int[][] dp){
        if(i >= rewards.length){
            return 0;
        }
        if(dp[i][sum] != -1){
            return dp[i][sum];
        }
        int take = 0 , nottake = 0;

        if(sum < rewards[i])
            take = findMax(rewards , i + 1 , sum + rewards[i] ,dp) + rewards[i];
        
        nottake = findMax(rewards , i + 1 , sum , dp);

        return dp[i][sum] = Math.max(take , nottake);
    }
}
