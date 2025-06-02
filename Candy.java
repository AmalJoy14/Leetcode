class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length , res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> Integer.compare(a[0],b[0]));
        for(int i = 0 ; i < n ; i++){
            pq.add(new int[]{ratings[i] , i});
        }
        int[] candies = new int[n];

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int idx = arr[1];
            int val = arr[0];
            
            int left = 0 , right = 0;
            if(idx - 1 >= 0 && ratings[idx - 1] < ratings[idx]) left = candies[idx - 1];
            if(idx + 1 < n && ratings[idx] > ratings[idx + 1]) right = candies[idx + 1];

            int candy = Math.max(left , right) + 1;
            candies[idx] = candy;
            res += candy;

            //System.out.println(Arrays.toString(visited) + " " + res); 
        }
        return res;
    }
}
