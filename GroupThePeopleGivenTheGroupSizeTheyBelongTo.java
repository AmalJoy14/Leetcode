class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0 ; i < groupSizes.length ; i++){
            if(!map.containsKey(groupSizes[i])){
                map.put(groupSizes[i], new ArrayList<>());
            }
            
            List<Integer> sub = map.get(groupSizes[i]);
            map.get(groupSizes[i]).add(i);
            if(sub.size() == groupSizes[i]){
                list.add(sub);
                map.put(groupSizes[i] , new ArrayList<>());
            }
        }

        return list;

    }
}
