class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int curr = 1;
        Arrays.sort(events , (a , b) -> Integer.compare(a[0] , b[0]));
        int index = 0 , n = events.length;
        int res = 0;
        
        while(index < n || !pq.isEmpty()){
            
            while(index < n && events[index][0]  == curr){
                pq.add(events[index][1]);
                index++;
            }
            while(!pq.isEmpty() && curr > pq.peek()){
                pq.poll();
            }
            if(!pq.isEmpty() && curr <= pq.peek()){
                pq.poll();
                res++;
                
                // System.out.println(curr + " " + res);
                
            }
            curr++;
        }
        
        return res;
        
    }
}
