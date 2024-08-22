class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int streak = 0 , max = 0;
        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i] == 0 ){
                streak = 0;
            } else {
                streak++;
            }
            if (streak > max){
                max = streak;
            }
        }
        return max;
    }
}
