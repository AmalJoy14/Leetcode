# Kadane's Algorithm

## Introduction
Kadane’s Algorithm is used to find the **maximum sum of a contiguous subarray** within a one-dimensional array of numbers. The algorithm is efficient with a time complexity of **O(n)**.

## Problem Statement
Given an array `arr[]` of size `n`, find the sum of the largest sum contiguous subarray.

## Example

**Input:**  
`arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4}`

**Output:**  
`6`  
(The contiguous subarray `[4, -1, 2, 1]` has the largest sum = `6`)

## Approach

The core idea is to keep track of two values:
1. **Current Subarray Sum (current_sum):** Sum of the subarray ending at the current position.
2. **Maximum Subarray Sum (max_sum):** Global maximum sum encountered.


### Java Code
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;

        /***********Kadane's Algorithm***************/
        for (int i = 0 ; i < nums.length ; i++){
            sum = sum + nums[i];
            max = Math.max(sum, max);
            if (sum < 0){
                sum = 0;
            }
        }

        
        return max;
    }
}

