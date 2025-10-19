class Solution {
    public int longestBalanced(int[] nums) {
        int res = 0 , n = nums.length;
        Set<Integer> odd = new HashSet<>();
        Set<Integer> even = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i ; j < n ; j++){
                if(nums[j] % 2 == 0){
                    even.add(nums[j]);
                }else{
                    odd.add(nums[j]);
                }
                if(odd.size() == even.size()){
                    res = Math.max(res , j - i + 1);
                }
            }
            odd = new HashSet<>();
            even = new HashSet<>();
        }
        return res;
    }
}
