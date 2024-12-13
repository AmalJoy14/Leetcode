class Solution {
    public long findScore(int[] nums) {
        int[] marked = new int[nums.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (Integer.compare(a[0], b[0]) == 0) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[] { nums[i], i });
        }

        long sum = 0;
        while (!pq.isEmpty()) {

            int[] arr = pq.poll();
            
            if (marked[arr[1]] == 0) {
                sum += arr[0];
                marked[arr[1]] = 1;
                if (arr[1] != 0) {
                    marked[arr[1] - 1] = 1;
                }
                if (arr[1] != nums.length - 1) {
                    marked[arr[1] + 1] = 1;
                }
            }
        }
        return sum;
    }
}
