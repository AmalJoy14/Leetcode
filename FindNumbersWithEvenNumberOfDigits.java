class Solution {
    public int findNumbers(int[] nums) {
        int count = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            int digits = 0;
            int val = nums[i];
            while(val != 0){
                digits++;
                val /= 10;
            }
            if(digits % 2 == 0) count++;
        }
        return count;
    }
}
