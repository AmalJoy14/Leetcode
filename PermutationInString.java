class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character , Integer> map1 = new  HashMap<>();

        for (int i = 0 ; i < s1.length() ; i++){
            char ch = s1.charAt(i);
            if (map1.containsKey(ch)){
                map1.put(ch, map1.get(ch) + 1);
            }
            else{
                map1.put(ch, 1);
            }
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        int left = 0, right = 0;
        int size = 0;
        while(right < s2.length()){

            char ch = s2.charAt(right);
            if (map2.containsKey(ch)){
                map2.put(ch, map2.get(ch) + 1);
            }
            else{
                map2.put(ch, 1);
            }
            if (map1.equals(map2)){
                return true;
            }
            size++;
            right++;
            

            if (size >= s1.length()){
                size--;
                char rem = s2.charAt(left);
                if ( map2.get(rem) == 1){
                    map2.remove(rem);
                }
                else {
                    map2.put(rem, map2.get(rem) - 1);
                }
                left++;
            }
           
        }
        return false;
    }
}
