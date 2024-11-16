class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < nums.length ; i++){
            min = Math.min(min , nums[i]);
            max = Math.max(max , nums[i]);
        }
        return gcd(max , min);
    }
    public int gcd(int max , int min){
        if (min == 0){
            return max;
        }
        return gcd(min , max % min);
    }
}
