class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0, hasPositive = 0;
        for(int num : nums){
            if(num != 0) hasPositive = 1;
            xor ^= num;
        }
        if(xor != 0) return nums.length;
        else{
            if(hasPositive == 1) return nums.length - 1;
            return 0;
        }
    }
    
}
