class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        // int[] carr = new int[n*2];
        // for(int i = 0 ; i < n ; i++){
        //     carr[i] = nums[i];
        //     carr[n + i] = nums[i];
        // }
        HashMap<Integer , Integer>  prevMap = new HashMap<>();
        HashMap<Integer , Integer>  nextMap = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            prevMap.put( nums[i] , i );
        }
        for(int i = n - 1 ; i >= 0 ; i--){
            nextMap.put(nums[i] , i);
        }
        int[] prev = new int[n];
        Arrays.fill(prev , -1);
        int[] next = new int[n];
        Arrays.fill(next , -1);
        
        for(int i = 0 ; i < n ; i++){
            if(prevMap.containsKey(nums[i])){
                if(prevMap.get(nums[i]) != i){
                    prev[i] = prevMap.get(nums[i]);
                    prevMap.put(nums[i] , i);
                }
            }
        }
        for(int i = n - 1 ; i >= 0 ; i--){
            if(nextMap.containsKey(nums[i])){
                if(nextMap.get(nums[i]) != i){
                    next[i] = nextMap.get(nums[i]);
                    nextMap.put(nums[i] , i);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        // System.out.println(Arrays.toString(next));
        //  System.out.println(Arrays.toString(prev));
        
        for(int i = 0 ; i < queries.length ; i++){
            int idx = queries[i];
            if(next[idx] != -1){
                int a = Math.abs(nums.length - idx + next[idx]);
                int b = Math.abs(next[idx] - idx);
                res.add(Math.min(a , b));
            }
            if(prev[idx] != -1){
                int a = Math.abs(idx + nums.length - prev[idx]);
                int b = Math.abs(prev[idx] - idx);
                int c = Math.min(a , b);
                if(res.get(i) > c){
                    res.remove(i);
                    res.add(c);
                }
                
            }
            else{
                res.add(-1);
            }
        }
        return res;
    }
}
