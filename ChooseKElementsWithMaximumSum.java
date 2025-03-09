class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[] res = new long[n];
        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            list.add(new int[]{nums1[i] , i , nums2[i]});
        }
        Collections.sort(list , (a , b) -> Integer.compare(a[0] , b[0]));
        // for(int i = 0 ; i < n ; i++){
        //     System.out.println(Arrays.toString(list.get(i)));
        // }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int prev = list.get(0)[0];
        long sum = 0;
        int m = 0;
        for(int i = 1 ; i < n ; i++){
            // System.out.println(m + " " + pq);
            int idx = list.get(i)[1];
            if(list.get(i)[0] != list.get(i - 1)[0]){
                while(m < i ){
                    if(pq.size() < k){
                        sum += list.get(m)[2];
                        pq.add(list.get(m)[2]);
                    }
                    else{
                        if(pq.peek() < list.get(m)[2]){
                            sum -= pq.poll();
                            sum += list.get(m)[2];
                            pq.add(list.get(m)[2]);
                        }
                    }
                    m++;
                }
            }
            res[idx] = sum;
            
        }
        return res;
    }
}
