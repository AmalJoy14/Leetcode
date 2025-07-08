class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events , (a , b) -> Integer.compare(a[0] , b[0]));
        int[][] dp = new int[events.length][k + 1];
        for(int[] num : dp)
            Arrays.fill(num , -1);
        return findMax( 0 , k , events , dp);
    }
    public int findMax(int i , int k ,int[][] events , int[][] dp){
        if(i >= events.length || k <= 0){
            return 0;
        }
        if(dp[i][k] != -1){
            return dp[i][k];
        }
        int take = Integer.MIN_VALUE , nottake = Integer.MIN_VALUE;
        
        
        nottake = findMax( i + 1 , k , events , dp);

        int next = findNext(events, i);
        take = events[i][2] + findMax(next, k - 1, events, dp);
        
        return dp[i][k] = Math.max(take , nottake);
    }

    private int findNext(int[][] events, int i) {
        int low = i + 1, high = events.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid][0] > events[i][1]) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
