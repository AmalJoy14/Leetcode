class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length, res = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            int num = nums[i];
            int rev = 0;
            while(num != 0){
                int rem = num % 10;
                num /= 10;
                rev = rev * 10 + rem;
            }
            if(map.containsKey(nums[i])){
                res = Math.min(res , i - map.get(nums[i]));
            }
            map.put(rev , i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
