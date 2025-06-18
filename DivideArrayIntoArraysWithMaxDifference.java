class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        int n = nums.length;
        int[][] res = new int[n / 3][3];
        int p = 0;
        for(int i = 0 ; i < n ; i += 3){
            int[] sub = new int[3];
            int start = nums[i];
            int j = 0 , q = 0;
            for( j = i ; j < i + 3 ; j++){
                sub[q] = nums[j];
                q++;
            }
            int end = nums[j - 1];
            if(end - start <= k){
                res[p] = sub;
                p++;
            }
            else{
                return new int[][]{};
            }
        }
        return res;
    }
}
