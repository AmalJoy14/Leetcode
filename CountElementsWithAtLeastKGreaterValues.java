class Solution {
    public int countElements(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        if(k == 0) return nums.length;
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i], 0) + 1);
        }
        for(int key : map.keySet()){
            pq.add(new int[]{key , map.get(key)});
        }
        int rem = nums.length;
        //System.out.println(map);
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int val = arr[0];
            int count = arr[1];
            rem -= count;
            if(rem >= k){
                res += count;
            }
        }
        return res;
    }
}
