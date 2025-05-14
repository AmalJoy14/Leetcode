class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer , Integer> map1 = new HashMap<>();
        HashMap<Integer , Integer> map2 = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(i % 2 == 0){
                map1.put(nums[i] , map1.getOrDefault(nums[i] , 0) + 1);
            }
            else{
                map2.put(nums[i] , map2.getOrDefault(nums[i] , 0) + 1);
            }
        }
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> Integer.compare(b[1] , a[1]));
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> Integer.compare(b[1] , a[1]));
        for(int key : map1.keySet()){
            pq1.add(new int[]{key , map1.get(key)});
        }
        for(int key : map2.keySet()){
            pq2.add(new int[]{key , map2.get(key)});
        }
        int half = (nums.length + 1) / 2;
        int half2 = nums.length % 2 == 0 ? half : half - 1;
        if(!pq1.isEmpty() && !pq2.isEmpty()){
            int[] arr1 = pq1.poll();
            int[] arr2 = pq2.poll();
            if(arr1[0] != arr2[0]){
                return (half - arr1[1]) + (half2 - arr2[1]);
            }
            else{
                int prev1 = 0;
                if(!pq1.isEmpty()) prev1 = pq1.peek()[1];
                int prev2 = 0;
                if(!pq2.isEmpty()) prev2 = pq2.peek()[1];
                
                return Math.min( (half - prev1) + (half2 - arr2[1]) , (half - arr1[1]) + (half2 - prev2) );
                
            }
        }
        return 0;
    }
}
