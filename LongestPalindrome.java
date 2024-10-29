class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch,0) + 1);
        }
        int flag = 0;
        int size = 0;
        for (int i : map.values()){
            if (i % 2 == 0){
                size += i;
            }
            else if (i % 2 != 0 && flag == 0){
                flag = 1;
                size += i;
            }
            else if (i % 2 != 0){
                size += i -1;
            }
        }
        return size;
    }
}
