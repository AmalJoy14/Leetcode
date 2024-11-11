class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;
        int j = nums.length - 2;
        int i, pivot = -1;
        for (i = nums.length - 1; j >= 0; i--) {
            if (nums[j] < nums[i]) {
                pivot = j;

                int nextGreaterIndex = nums.length - 1;
                for (int k = pivot ; k < nums.length ; k++){
                    if (nums[k] > nums[pivot]){
                        nextGreaterIndex = k;
                    }
                }
                

                int temp = nums[pivot];
                nums[pivot] = nums[nextGreaterIndex];
                nums[nextGreaterIndex] = temp;
                break;
            }
            j--;
        }

        //Sorting them in ascending order.
        for (int k = pivot + 1 ; k < nums.length ; k++){
            for (int l = k + 1 ; l < nums.length ; l++){
                if (nums[l] < nums[k]){
                    int temp = nums[k];
                    nums[k] = nums[l];
                    nums[l] = temp;
                }
            }
        }
    }
}
