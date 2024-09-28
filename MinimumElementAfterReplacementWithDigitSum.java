class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < nums.length ; i++){
            int n = nums[i];
            int sum = 0;
            while(n != 0){
                int rem = n % 10;
                n = n/ 10;
                sum += rem;
            }
            nums[i] = sum;
            min = Math.min(min , sum);
        }
        return min;
    }
}
