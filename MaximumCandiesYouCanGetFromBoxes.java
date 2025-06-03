class Solution {
    HashSet<Integer> set = new HashSet<>();
    HashSet<Integer> stopped = new HashSet<>();

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int res = 0;
        for(int i =  0 ; i < initialBoxes.length ; i++){
            res += findCandies(status , candies , keys, containedBoxes, initialBoxes[i]);
        }
        return res;
    }
    public int findCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes , int idx){
        int res = 0;
        
        if(status[idx] == 1 || set.contains(idx)){
            for(int i = 0 ; i < keys[idx].length ; i++){
                set.add(keys[idx][i]);
                if(stopped.contains(keys[idx][i])){
                    stopped.remove(keys[idx][i]);
                    res += findCandies(status , candies , keys , containedBoxes , keys[idx][i]);
                }
            }

            for(int i = 0 ; i < containedBoxes[idx].length ; i++){
                res += findCandies(status , candies , keys , containedBoxes , containedBoxes[idx][i]);
            }
            res += candies[idx];
        }
        else{
            stopped.add(idx);
        }
        return res;
    }
}
