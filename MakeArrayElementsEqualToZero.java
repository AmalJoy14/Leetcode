class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length , sum = 0 , res = 0;
        int[] sumArr = new int[n + 2];
        for(int i = 0; i < n ; i++){
            sum += nums[i];
            sumArr[i + 1] = sum;
        }
        for(int i = 0 ; i < n; i++){
            if(nums[i] == 0){
                int leftval = sumArr[i];
                int rightval = sumArr[n] - sumArr[i + 1];
                if(leftval == rightval) res += 2;
                else if(leftval == rightval + 1 || rightval == leftval + 1){
                    res += 1;
                }
            }
        }
        return res;
    }
}
