class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < answers.length ; i++){
            map.put(answers[i] , map.getOrDefault(answers[i], 0) + 1);
        }
        int res = 0;
        for(int key : map.keySet()){
            int val = map.get(key);
            
            while(val > 0){
                res += key + 1;
                val -= key + 1;
            }
        }
        return res;
    }
}
