class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> Integer.compare(b[1],a[1]));

        for(int i = 0 ; i < x.length ; i++){
            pq.add(new int[]{x[i] , y[i]});
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        while(!pq.isEmpty() && set.size() < 3){
            int[] arr = pq.poll();
            if(!set.contains(arr[0])){
                set.add(arr[0]);
                res += arr[1];
            }
        }
        if(set.size() != 3)return -1;
        return res;
    }
}
