class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0 ; i < gifts.length ; i++){
            pq.add(gifts[i]);
        }
        for(int i = 0 ; i < k ; i++){
            int val = pq.poll();
            val = (int)(Math.sqrt(val));
            pq.add(val);
        }
        
        long sum = 0;
        for (int i = 0 ; i < gifts.length ; i++){
            sum += pq.poll();
        }
        return sum;
    }
}
