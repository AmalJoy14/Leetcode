class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue <Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0 ; i < nums.length ; i++){
            maxHeap.add(nums[i]);
        }
        for (int i = 1 ; i < k ; i++){
            maxHeap.poll();
        }
        return maxHeap.poll();
    }
}
