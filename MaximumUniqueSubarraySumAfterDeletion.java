class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int e : nums){
            set.add(e);
        }
        int sum = Integer.MIN_VALUE;
        for(int e : set){
            if(e < 0 && sum < e) {
                sum = e;
                continue;
            }
            if(e >= 0 && sum < 0){
                sum = 0;
                sum += e;
            }
            else if(e >= 0 && sum >= 0){
                sum += e;
            }
            
        }
        return sum;
    }
}
