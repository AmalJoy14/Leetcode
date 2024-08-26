class Solution {
    public void rotate(int[] nums, int k) {
        Queue<Integer> que = new LinkedList<>();
        int size = nums.length;
        for (int i = size - 1 - k % size; i >= 0 ; i--){
            que.add(nums[i]);
        }
        for (int i = size - 1 ; i > size - 1 - k % size ; i --){
            que.add(nums[i]);
        }
        for (int i = size - 1 ; i >= 0 ; i--){
            nums[i] = que.remove();
        }
    }
}
