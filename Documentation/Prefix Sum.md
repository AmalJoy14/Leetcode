# Subarray Sum Equals K (Prefix Sum)

## Problem Description
Given an integer array `nums` and an integer `k`, find the total number of continuous subarrays whose sum equals `k`.
This is solved efficiently using the **prefix sum** technique with a HashMap.

---
## Explanation of the Code

1. **Initialization**:
   - `prefixSum` is a HashMap to store prefix sums and their frequencies.
   - `sum` keeps a running total of the array elements.
   - `count` tracks the number of subarrays with sum equal to `k`.

2. **Iterating Through the Array**:
   - Add the current element `nums[i]` to `sum`.

3. **Checking for Subarrays**:
   - If `sum == k`, increment `count` since a subarray starting from index 0 matches.
   - If `(sum - k)` exists in `prefixSum`, it means there are previous prefix sums sum[j-1] such that the subarray from index j to i has the sum k.
   - Add the frequency of such cases add it to `count`

4. **Update HashMap**:
   - Store or update the frequency of the current `sum` in `prefixSum`

---

## Code Implementation
```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        
        //Prefix Sum
        HashMap <Integer,Integer> prefixSum = new HashMap<>();
        int sum = 0, count = 0;
        for (int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            
            if (sum == k){
                count++;
            }
            if (prefixSum.containsKey(sum - k)){
                count += prefixSum.get(sum - k);
            }
            prefixSum.put(sum , prefixSum.getOrDefault(sum , 0) + 1);
        }
        return count;
    }
}
