class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] nextSmall = new int[heights.length];
        int[] prevSmall = new int[heights.length];

        //Monotonic Stack Increasing
        Stack<Integer> stk = new Stack<>();
        for(int i = 0 ; i < heights.length ; i++){
            while(!stk.isEmpty() && heights[stk.peek()] > heights[i]){
                int idx = stk.pop();
                nextSmall[idx] = i;
            }
            if(stk.isEmpty()) prevSmall[i] = -1;
            else prevSmall[i] = stk.peek();
            stk.push(i);
        }
        while(!stk.isEmpty()){
            nextSmall[stk.pop()] = heights.length;
        }
        for(int i = 0 ; i < heights.length ; i++){
            res = Math.max((int)heights[i] * (nextSmall[i] - prevSmall[i] - 1) , res);
        }
        return res;
    }
}
