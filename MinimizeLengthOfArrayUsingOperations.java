class Solution {
    public int minimumArrayLength(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            min = Math.min(num , min);
        }
        int count = 0;
        for(int num : nums){
            if(num % min != 0) return 1;
            if(num == min ) count++;
        }
        return count/2 + count % 2;
    }
}
