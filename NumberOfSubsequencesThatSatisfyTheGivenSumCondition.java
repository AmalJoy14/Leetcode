class Solution {
    int MOD = 1_000_000_007;
    public int numSubseq(int[] nums, int target) {
        int[] power = new int[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            power[i] = (power[i - 1] * 2) % MOD;
        }
        Arrays.sort(nums);
        long res = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int count = findCount(i ,target - nums[i] , nums);
            if(count < 1) continue; 
            res = (res %MOD+ ( power[count - 1])) % MOD;
            
        }
        return (int)res % MOD;
    }
    public int findCount(int idx , int val , int[] nums){
        int left = idx , right = nums.length - 1;
        int res = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] <= val){
                res = mid;
                left = mid + 1;
            } 
            else{
                right = mid - 1;
            }
        }
        
        return res + 1 - idx;
    }
}
