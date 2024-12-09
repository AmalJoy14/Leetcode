class Solution {
    public String minWindow(String s, String t) {
        //Read Hint.
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < t.length() ; i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int resLeft = -1,resRight = -1;

        int left = 0;
        for (int right = 0 ; right < s.length() ; right++){
            if (map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
            }
            int flag = 1;
            for (int e : map.values()){
                if (e > 0){
                    flag = 0;
                }
            }
            while (flag == 1){      //All characters in t are covered.   
                while(!map.containsKey(s.charAt(left))){
                    left++;
                }
                
                if (resLeft == -1 || resRight - resLeft > right - left){
                    resLeft = left;
                    resRight = right;
                }
                
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                left++;
                
                for (int e : map.values()){
                    if (e > 0){
                        flag = 0;
                    }
                }

            }
            // System.out.println(s.substring(left,right + 1));
        }
        if (resLeft == -1){
            return "";
        }
        return s.substring(resLeft, resRight + 1);
    }
}
