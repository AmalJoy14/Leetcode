class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer,Integer> rainSet = new HashMap<>();
        TreeSet<Integer> lifeLine = new TreeSet<>();
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans , -1);
        for(int i = n - 1 ; i >= 0 ; i--){
            if(rains[i] != 0 && rainSet.containsKey(rains[i])){
                if(lifeLine.isEmpty()) return new int[]{};
                Integer idx = lifeLine.lower(rainSet.get(rains[i]));
                if(idx == null) return new int[]{}; 
                ans[idx] = rains[i];
                lifeLine.remove(idx);
                rainSet.put(rains[i] , i);
            }else if(rains[i] == 0){
                lifeLine.add(i);
            }else{
                rainSet.put(rains[i] , i);
            }
            
        }
        int uniq = -1;
        for(int i = 1; i <= 100001 ; i++){
            if(!rainSet.containsKey(i)) {
                uniq = i;
                break;
            }
        }
        while(!lifeLine.isEmpty()){
            ans[lifeLine.pollFirst()] = uniq;
        }
        return ans;
    }
}
