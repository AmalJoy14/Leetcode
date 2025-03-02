class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int max = -1;
        HashMap<Integer , Integer> map = new HashMap<>();
        int a = nums[0], b = nums[n - 1];
        
            for(int i = 0 ; i < n ; i++){
                if(i != 0 && a == nums[i]){
                    a = -1;
                }
                if(i != n - 1 && nums[i] == b){
                    b = -1;
                }
                map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
            }
        
                // System.out.println(map);
        int smax = -1;
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                max = Math.max(max , key);
            }
            smax = Math.max(smax , key);
        }

        
        if(k == 1 ) return max;
        if(k == n) return smax;
        return Math.max(a , b);
    }
}
