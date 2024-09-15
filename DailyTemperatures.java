class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stk = new Stack<>();  // Stack stores indices
        int[] res = new int[temp.length];

        for (int i = temp.length - 1; i >= 0; i--) {
            // Pop indices from the stack while the current temp is greater or equal to stack's top temp
            while (!stk.isEmpty() && temp[i] >= temp[stk.peek()]) {
                stk.pop();
            }
            
            // If the stack is not empty, we found a warmer day, otherwise res[i] remains 0
            res[i] = stk.isEmpty() ? 0 : stk.peek() - i;

            // Push the current index onto the stack
            stk.push(i);
        }

        return res;
    }
}
