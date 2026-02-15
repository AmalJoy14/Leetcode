class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n = value.length;
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            arr[i][0] = value[i];
            arr[i][1] = limit[i];
        }
        Arrays.sort(arr , (a, b) -> {
            if(a[1] == b[1]){
                return Integer.compare(b[0] , a[0]);
            }else{
                return Integer.compare(a[1] , b[1]);
            }
        });
        long res = 0;
        int curr = 0 , inActive = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            if(arr[i][1] <= inActive) continue;

            if(curr < arr[i][1]){
                res += arr[i][0];
                curr++;
                pq.add(arr[i][1]);
                inActive = Math.max(inActive , curr);
            }
            int count = 0;
            while(!pq.isEmpty() && pq.peek() <= curr){
                count++;
                pq.poll();
            }
            curr -= count;
        }
        return res;
    }
}
