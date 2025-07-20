class Solution {
    int MOD = 1_000_000_007;
    public int countTrapezoids(int[][] points) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < points.length ; i++){
            int x = points[i][0];
            int y = points[i][1];
            map.put(y , map.getOrDefault(y , 0) + 1);
        }
        long res = 0 , flag = 0;
        ArrayList<Long> list = new ArrayList<>();
        for(int key : map.keySet()){
            long count = map.get(key);
            if(count == 1) continue;
            else flag++;
            count--;
            long options = (count * (count + 1)) / 2;
            options = options % MOD;
            list.add(options);
        }
        long[] preSum = new long[list.size()];
        long summ = 0;
        for(int i = list.size() - 1 ; i >= 0 ; i--){
            preSum[i] = summ;
            summ += list.get(i);
            summ %= MOD;
        }
        //System.out.println(list + " " + Arrays.toString(preSum));
        for(int i = 0 ; i < list.size() - 1; i++){
            res += (list.get(i) * preSum[i]) % MOD;
            res %= MOD;
        }
        if(flag < 2){
            return 0;
        }
        return (int)res;
    }
}
