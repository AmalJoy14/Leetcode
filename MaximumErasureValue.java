class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0 , left = 0 , max = 0;
        
        for(int right = 0 ; right < nums.length ; right++){
            int ele = nums[right];
            while(set.contains(ele)){
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            sum += ele;
            set.add(ele);
            max = Math.max(sum , max);
        }
            
        return max;
    }
}
