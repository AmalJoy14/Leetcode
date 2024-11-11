class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;
        int j = nums.length - 2;
        int i, pivot = -1;

        /*
         * 1)Finding the pivot (We cannot find the next permutation from the elements after pivot
         *                      as they are already in decreasing order ie.,they form the largest value)
         */
        for (i = nums.length - 1; j >= 0; i--) {
            if (nums[j] < nums[i]) {
                pivot = j;
                break;
            }
            j--;
        }

        // 2) Finding the minimum possible element greater than pivot element.
        int nextGreaterIndex = -1;
        for (int k = pivot; pivot != -1 && k < nums.length; k++) {
            if (nums[k] > nums[pivot]) {
                nextGreaterIndex = k;
            }
        }

        // 3) Swapping pivot element with next Greater Element.
        if (pivot != -1){
            int temp = nums[pivot];
            nums[pivot] = nums[nextGreaterIndex];
            nums[nextGreaterIndex] = temp;
        }
        

        // 4) Sorting elements after pivot in ascending order.
        int l = nums.length - 1;
        int k = pivot + 1;
        while(k < l){
            int temp = nums[k];
            nums[k] = nums[l];
            nums[l] = temp;    
            k++;
            l--;
        }
    }
}
