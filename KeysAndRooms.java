class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        return unlockRooms(0 , rooms , set );
    }

    public boolean unlockRooms(int i , List<List<Integer>> rooms , Set<Integer> set){
        set.add(i);
        if(set.size() == rooms.size()){
            return true;
        }

        for(int num : rooms.get(i)){
            if(set.contains(num)) continue;
            if(unlockRooms(num , rooms , set)){
                return true;
            }
        }
        return false;
    }
}
