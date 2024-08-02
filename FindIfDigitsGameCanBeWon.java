class Solution {
    public boolean canAliceWin(int[] nums) {
        int oneD = 0 ,twoD = 0; 
        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i] > 9){
                twoD += nums[i];
            } else {
                oneD += nums[i];
            }
        }
        if (twoD == oneD){
            return false;
        }
        return true;
    }
}
