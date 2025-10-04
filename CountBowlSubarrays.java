class Solution {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length, maxi = 0;
        int[] nxtGrt = new int[n];
        int[] prevGrt = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(maxi > nums[i]) prevGrt[i] = 1;
            else maxi = nums[i];
        }
        maxi = 0;
        for(int i = n - 1; i >= 0 ; i--){
            if(maxi > nums[i]) nxtGrt[i] = 1;
            else maxi = nums[i];
        }
        long res = 0;
        for(int i = 1; i < n - 1; i++){
            if(nxtGrt[i] == 1 && prevGrt[i] == 1){
                res++;
            }
        }
        return res;
    }
}
