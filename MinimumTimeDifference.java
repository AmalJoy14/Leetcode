class Solution {
    public int findMinDifference(List<String> timePoints) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String s : timePoints){
            int hr = Integer.parseInt(s.substring(0,2));
            int min = Integer.parseInt(s.substring(3,5));
            int time = hr * 60 + min;
            pq.add(time);
            pq.add(time + 24*60);
        }
        int res = Integer.MAX_VALUE;
        int prev = pq.poll();

        while(!pq.isEmpty()){
            int curr = pq.poll();
            res = Math.min(res , curr - prev);
            prev = curr;
        }
        return res;
    }
}
