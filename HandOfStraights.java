class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        ConcurrentHashMap <Integer,Integer> map = new ConcurrentHashMap<>();
        for(int i = 0 ; i < hand.length ; i++){
            map.put(hand[i], map.getOrDefault(hand[i],0) + 1);
        }
        Arrays.sort(hand);
        for(int j = 0 ; j < hand.length ; j++){
            if (!map.containsKey(hand[j])){
                continue;
            }
            int e = hand[j];
            if(!map.containsKey(e - 1)){
                // System.out.println(e);
                for(int i = 0; i < groupSize ; i++){
                    if(map.containsKey(e + i)){
                        map.put(e+i, map.get(e+i) - 1);
                        if(map.get(e+i) ==0){
                            map.remove(e+i);
                        }
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
