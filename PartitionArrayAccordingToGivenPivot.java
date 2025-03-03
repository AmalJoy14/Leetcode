class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int k = 0;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < pivot){
                res[k] = nums[i];
                k++;
            }
            else if(nums[i] == pivot){
                count++;
            }
        }
        while(count > 0){
            res[k] = pivot;
            k++;
            count--;
        }
        for(int i = 0 ;  i < n ; i++){
            if(nums[i] > pivot){
                res[k] = nums[i];
                k++;
            }
        }
        return res;
    }
}
