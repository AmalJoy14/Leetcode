class Solution {
    public int minNumberOperations(int[] target) {
        int max = 0 , n = target.length;
        Map<Integer , List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(-1);
        set.add(n);
        for(int i = 0 ; i < target.length ; i++){
            int num = target[i];
            if(!map.containsKey(num)){
                map.put(num , new ArrayList<>());
            }
            map.get(num).add(i);
            max = Math.max(max , num);
        }
        int noOfArr = 1 , res = 0;
        for(int i = 1 ; i <= max ; i++){
            res += noOfArr;
            if(!map.containsKey(i)) continue;
            List<Integer> idxArr = map.get(i);
            for(int idx : idxArr){
                if(set.contains(idx - 1) && set.contains(idx + 1)) noOfArr--;
                else if(!set.contains(idx - 1) && !set.contains(idx + 1)) noOfArr++;
                set.add(idx);
            }
        }
        return res;
    }
}
