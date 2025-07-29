class Solution {
    public int minimizeArrayValue(int[] nums) {
        int max = 0;
        for(int num : nums){
            max = Math.max(max , num);
        }
        int left = 0 , right = max , res = max;
        while(left <= right){
            int mid = left + (right - left) / 2;
            //System.out.println(mid);
            if(isPossible(mid , nums)){
                res = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return res;
    }

    public boolean isPossible(int mid , int[] nums){
        long[] arr = new long[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            arr[i] = nums[i];
        }
        
        for(int i = 1 ; i < nums.length ; i++){
            //System.out.println(i + " " + mid + " " +Arrays.toString(arr));
    
            if(arr[i - 1] > mid) return false;
            long diff = mid - arr[i - 1];
            arr[i - 1] += diff;
            arr[i] -= diff;  
        }
        if(arr[arr.length - 1] > mid) return false;
        return true;
    }
}
