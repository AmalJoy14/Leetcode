class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : power){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        ArrayList<int[]> list = new ArrayList<>();
        for(int key : map.keySet()){
            list.add(new int[]{key , map.get(key)});
        }
        Collections.sort(list , (a,b) -> Integer.compare(a[0] , b[0]));
        long[] dp = new long[list.size()];
        Arrays.fill(dp , -1);
        return findMax(list , 0 , dp);
    }
    public long findMax(ArrayList<int[]> list , int idx , long[] dp){
        if(idx >= list.size()){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        long take = 0 , nottake = 0;
        nottake = findMax(list , idx + 1 , dp );
        if(idx < list.size() - 1 && list.get(idx + 1)[0] > list.get(idx)[0] + 2){
            take = findMax(list , idx + 1 , dp);
        }else if(idx < list.size() - 2 && list.get(idx + 2)[0] > list.get(idx)[0] + 2){
            take = findMax(list , idx + 2 , dp);
        }else{
            take = findMax(list , idx + 3 ,dp);
        }
        take += list.get(idx)[0] * (long)list.get(idx)[1];
        return dp[idx] = Math.max(take , nottake);
    }
}
