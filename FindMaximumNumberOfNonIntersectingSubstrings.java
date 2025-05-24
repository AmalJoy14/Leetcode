class Solution {
    public int maxSubstrings(String word) {
        int n = word.length() , res = 0;
        HashMap<Character , Integer>  map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            char ch = word.charAt(i);
            if(map.containsKey(ch)){
                if(i - map.get(ch) >= 3){
                    res++;
                    map = new HashMap<>();
                }
            }
            else{
                map.put(ch , i);
            }
        }
        return res;
    }
}
