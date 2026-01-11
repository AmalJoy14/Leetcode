class Solution {
    public long countSubstrings(String s, char c) {
        long res = 0 , count = 1;
        for(int i = 0 ; i< s.length() ;i++){
            if(s.charAt(i) == c){
                res += count;
                count++;
            }
        }
        return res;
    }
}
