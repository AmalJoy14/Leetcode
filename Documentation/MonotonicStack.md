# Monotonic Stack : Next Greater Element
```java
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n]; 
        Stack<Integer> stack = new Stack<>();  // Stack to store indices
        
        
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        for (int i = 0; i < n; i++) {
                                                                                             // While stack is not empty and current element is greater than the element at the top index of the stack
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();                                                     // Pop the index from the stack
                res[index] = nums[i];                                                        // Set the next greater element for that index
            }

            stack.push(i);
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        return res;
    }
```
```java

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 1, 2, 4, 3};
        int[] result = sol.nextGreaterElements(nums);

        // Print the result array
        for (int r : result) {
            System.out.print(r + " ");
        }
        // Output: 4 2 4 -1 -1
    }
}
