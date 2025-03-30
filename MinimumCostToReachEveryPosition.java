class Solution {
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] res = new int[n];
        int min = 404;
        for(int i = 0 ; i < n ; i++){
            min = Math.min(min ,cost[i] );
           res[i] = min;
        }
        return res;
    }
}
