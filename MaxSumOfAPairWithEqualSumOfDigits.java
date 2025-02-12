class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length , res = -1;
        HashMap<Integer , PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            int digitSum = digitSum(nums[i]);
            if(map.containsKey(digitSum)){
                PriorityQueue<Integer> pq = map.get(digitSum);
                pq.add(nums[i]);
                if(pq.size() > 2){
                    pq.poll();
                }
            }
            else{
                map.put(digitSum , new PriorityQueue<>());
                map.get(digitSum).add(nums[i]);
            }
        }

        for(int e : map.keySet()){
            PriorityQueue<Integer> pq = map.get(e);
            if(pq.size() >= 2){
                int a = pq.poll();
                int b = pq.poll();
                res = Math.max(a + b , res);
            }
        }
        return res;
    }

    public int digitSum(int n){
        int sum = 0;
        while(n != 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
