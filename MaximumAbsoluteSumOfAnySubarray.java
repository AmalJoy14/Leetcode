class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int largest = 0 ;
        int smallest = 0;
        int prefixSum = 0;
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++){
            prefixSum += nums[i];
            if(prefixSum < 0){
                res = -(prefixSum - largest) >  res ? -(prefixSum - largest) : res;
            }
            else {
                res = (prefixSum - smallest) > res ? (prefixSum - smallest) : res;
            }
            largest = largest < prefixSum ? prefixSum : largest;
            smallest = smallest > prefixSum ? prefixSum : smallest;
        }
        return res;
    }
}
