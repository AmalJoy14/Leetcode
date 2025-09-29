class Solution {
    public long splitArray(int[] nums) {
        
        long leftSum = 0 , rightSum = 0 ;
        int left = 0 , right = nums.length - 1;
        while(left < nums.length - 1 && nums[left] < nums[left + 1]){
            leftSum += nums[left];
            left++;
        }
        while(right > 0 && nums[right - 1] > nums[right]){
            rightSum += nums[right];
            right--;
        }
        //System.out.println(left + " " + right);
        if(left != right && left + 1 != right) return -1;

        if(left == right){
            return Math.min(Math.abs(leftSum - rightSum + nums[left])  , Math.abs(rightSum - leftSum + nums[right]));
        }else{
            return Math.abs(leftSum - rightSum);
        }
    }
}
