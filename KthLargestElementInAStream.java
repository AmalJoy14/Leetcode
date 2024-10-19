class KthLargest {
    PriorityQueue<Integer> minHeap ;
    int k;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        for (int e : nums){
            minHeap.add(e);
        }
        this.k = k;
        while(minHeap.size() > k){
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        if (minHeap.isEmpty() ){
            minHeap.add(val);
        }
        else if (minHeap.size() < k){
            minHeap.add(val);
        }
        else if (val >= minHeap.peek()){
            minHeap.add(val);
            minHeap.poll();
        }
        
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
