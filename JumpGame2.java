class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int target = nums.length - 1;
        while(target != 0){
            int max = 0;
            for(int j = target ; j >= 0 && j >= target -1000 ;j--){
                if(j + nums[j] >= target){
                    max = j;
                }
            }
            target = max;
            count++;
        }
        return count;
    }
}
