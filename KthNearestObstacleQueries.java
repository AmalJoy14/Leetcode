class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        int[] results = new int[queries.length];
        //
        for (int i = 0; i < queries.length; i++) {
            int x,y,dist;
            x = queries[i][0];
            y = queries[i][1];
            dist = Math.abs(x) + Math.abs(y);
            max.offer(dist);
            
            if (max.size() > k)
                max.poll();
            if (max.size() < k) 
                results[i] = -1;
            else
                results[i] = max.peek();
        }
        return results;
    }
}
