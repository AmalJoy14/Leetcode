class Solution {
    public int longestNiceSubarray(int[] nums) {
        int res = 0 , max = 1 , j = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if((nums[i] & res) == 0){
                res = res | nums[i];
            }
            else{
                while((nums[i] & res) != 0 && j < i){
                    res = res ^ nums[j];
                    j++;
                }
                res = res | nums[i];
            }
            max = Math.max(i - j + 1, max);
        }
        return max;
    }
}
