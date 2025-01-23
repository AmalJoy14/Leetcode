class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;

        int start = -1 , end = -1;
        
        for(int i = 0 ; i < n - 1 ; i++){
            if(nums[i] > nums[i + 1]){
                start = i;
                break;
            }
        }
        for(int i = n - 1 ; i > 0 ; i--){
            if(nums[i] < nums[i - 1]){
                end = i;
                break;
            }
        }
        if(start == -1 && end == -1) return 0;

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = start ; i <= end ; i++){
            max = Math.max(max , nums[i]);
            min = Math.min(min , nums[i]);
        }
        // System.out.println(max+ " " + min);
        int i = start;
        while(i > 0 && nums[i - 1] > min){
            i--;
            start--;
        }
        i = end;
        while(i < n - 1 && max > nums[i + 1]){
            i++;
            end++;
        }
        return end - start + 1;
    }
}
