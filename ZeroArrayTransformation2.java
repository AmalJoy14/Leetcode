class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int[] start = new int[nums.length];
        int[] end = new int[nums.length];
        int decr = 0;
        int k = 0;
        for(int i = 0 ; i < nums.length ; i++){
            decr += start[i];
            
            while(k < queries.length && nums[i] - decr > 0){
                if(queries[k][0] <= i && queries[k][1]  >= i){
                    decr += queries[k][2];
                    end[queries[k][1]] += queries[k][2];
                    k++;
                }
                else{
                    start[queries[k][0]] += queries[k][2];
                    end[queries[k][1]] += queries[k][2];
                    k++;
                }
            }
            if(nums[i] - decr > 0) return -1;
            decr -= end[i];
        }
        return k;
    }
}
