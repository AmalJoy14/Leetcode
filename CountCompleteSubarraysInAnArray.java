class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        HashMap<Integer , Integer> subset = new HashMap<>();
        int left = 0;
        
        for(int right = 0; right < nums.length ; right++){
            subset.put(nums[right] , right);

            
            int flag = subset.size() == set.size() ? 0 : 1;

            if(flag == 0){
                while(left < nums.length ){
                    //System.out.println(left + " " + right);
                    if(subset.get(nums[left]) == left){
                        subset.remove(nums[left]);
                        res += nums.length - right;
                        left++;
                        break;
                    }
                    res += nums.length - right;
                    left++;
                }
            }
        }
        return res;
    }
}
