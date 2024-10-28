class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        int j = 0;
        for (int i = 0 ; i < s.length() ; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(j);
            if (!map.containsKey(ch1)){
                if (map.values().contains(ch2)){
                    return false;
                }
                map.put(ch1,ch2);
            }
            else{
                if (map.get(ch1) != ch2){
                    return false;
                }
            }
            j++;
        }
        return true;
    }
}
