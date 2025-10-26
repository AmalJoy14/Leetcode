class Solution {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
        long sum = 0 , res = 0;
        HashMap<Long ,HashMap<Long,Long>> mainmap = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            long val = capacity[i];
            if(!mainmap.containsKey(val)){
                mainmap.put(val , new HashMap<>());
            }
            Map<Long,Long> map = mainmap.get(val);
            long count = map.getOrDefault(sum - val , 0L);
            if(i > 0 && val == 0 && capacity[i - 1] == 0){
                count--;
            }
            res += count;
            //System.out.println(res +" " + sum +" " + i );
            //System.out.println(mainmap);
            sum += val;
            
            map.put(sum , map.getOrDefault(sum , 0L ) + 1);
        }
        
        return res;
    }
}
