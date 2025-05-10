class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum = 0, flag1 = 0;
        for(int i = 0 ; i < nums2.length ; i++){
            sum += nums2[i] == 0 ? 1 : nums2[i];
            if(nums2[i] == 0) flag1 = 1;
        }
        long sum2 = 0 , flag2 = 0;
        for(int i = 0 ; i < nums1.length ; i++){
            sum2 += nums1[i] == 0 ? 1 : nums1[i];
            if(nums1[i] == 0) flag2 = 1;
        }
        if(sum2 > sum && flag1 == 0 || sum > sum2 && flag2 == 0){
            return -1;
        }
        return Math.max(sum , sum2);
    }
}
