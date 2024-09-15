class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
        }
        int[] test = new int[nums.length*2];
        for (int i = 0; i < nums.length*2; i++) {
            test[i] = nums[i % nums.length];
        }

        for (int i = 0; i < test.length; i++) {
            while (!stk.isEmpty() && test[i] > test[stk.peek()]) {
                int index = stk.pop();
                res[index] = test[i];
            }

            stk.push(i% nums.length);
        }

        return res;
    }
}
