# Next Permutation

## Problem Statement
Given an array of integers `nums`, find the **next lexicographical permutation** of the array. If no such permutation exists (i.e., the array is sorted in descending order), rearrange `nums` to its smallest possible permutation (sorted in ascending order).

### Example
**Input:**  
`nums = [1, 2, 3, 6, 5, 4]`  

**Output:**  
`[1, 2, 4, 3, 5, 6]`  

## Approach

To find the next lexicographical permutation:

1. **Identify the Pivot:** Traverse the array from the end to find the first element `nums[j]` that is smaller than its next element `nums[i]`. This element is the "pivot" that needs to be swapped to find the next permutation. If no such element exists, the array is in descending order, so reverse it to get the smallest permutation.

2. **Find the Successor:** Find the smallest element that is greater than `nums[pivot]` (let’s call this `nextGreaterElement`), and swap `nums[pivot]` and `nums[nextGreaterIndex]`.

3. **Reverse the Suffix:** Reverse the elements from `pivot + 1` to the end of the array to get the next lexicographical order.

## Code Implementation

### Java Code
```java
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
