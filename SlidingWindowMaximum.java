class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0 ; i < k ; i++){
            while(!dq.isEmpty() && dq.peekLast() < nums[i]){
                dq.removeLast();
            }
            dq.addLast(nums[i]);
        }
        int ptr = 0, left = 0;
        for (int i = k ; i < nums.length ; i++){
            res[ptr] = dq.peekFirst();
            ptr++;

            while(!dq.isEmpty() && dq.peekLast() < nums[i]){
                dq.removeLast();
            }
            dq.addLast(nums[i]);

            if (dq.peekFirst() == nums[left]){
                dq.removeFirst();
            }
            left++;
        }
        res[ptr] = dq.peekFirst();
        return res;
    }
}
