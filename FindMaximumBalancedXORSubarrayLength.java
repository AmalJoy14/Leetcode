class Solution {
    public int maxBalancedSubarray(int[] nums) {
        int res = 0;
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        map.put(0 , new HashMap<>());
        map.get(0).put(0 , -1);
        int xor = 0, odd = 0 , even = 0;
        for(int i = 0 ; i < nums.length ; i++){
            xor = nums[i] ^ xor;
            if(nums[i] % 2 == 0){
                even++;
            }else{
                odd++;
            }
            int key = even - odd;
            if(map.containsKey(xor)){
                Map<Integer ,Integer> sub = map.get(xor);
                if(sub.containsKey(key)){
                    int len = (i - sub.get(key));
                    res = Math.max(res , len);
                }
            }
            if(!map.containsKey(xor)){
                map.put(xor , new HashMap<>());
            }
            Map<Integer,Integer> sub = map.get(xor);
            if(!sub.containsKey(key)){
                sub.put(key , i);
            }
            //System.out.println(map);
        }
        return res;
    }
}
