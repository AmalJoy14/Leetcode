class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] start = new int[n];
        
        int str = 0;
        for(int i = 1 ; i < n ; i++){
            
            if(Math.abs(nums[i] - nums[i - 1]) > maxDiff){
                str = i ;
            }
            start[i] = str;
        }
        int m = queries.length;
        boolean[] res = new boolean[m];
        for(int i = 0 ; i < m ; i++){
            int idx1 = Math.min(queries[i][0] , queries[i][1]);
            int idx2 = Math.max(queries[i][0] , queries[i][1]);
            if(start[idx1] == start[idx2]){
                res[i] = true;
            }
        }
        return res;
    }
}
