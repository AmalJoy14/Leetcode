class Solution {
    public int singleNumber(int[] nums) {
       
        for (int i=0 ; i<nums.length; i++){
             int flag=0;
            for (int j=0;j<nums.length; j++){
                if (i==j) continue;
                if (nums[i]==nums[j]) {
                    flag=1;
                    break;}
            }
            if (flag==0)
             return nums[i];
        }
        return -1;
    }
}
