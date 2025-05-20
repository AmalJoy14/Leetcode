class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length , m = queries.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0 ; i < m ; i++){
            start[queries[i][0]]++;
            end[queries[i][1]]++;
        }
        int sub = 0;
        for(int i = 0 ; i < n ; i++){
            sub += start[i];
            if(nums[i] - sub > 0) return false;
            sub -= end[i];
        }
        return true;
    }
}
