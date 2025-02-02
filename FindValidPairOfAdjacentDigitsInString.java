class Solution {
    public String findValidPair(String s) {
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) != s.charAt(i - 1)){
                int a = Integer.parseInt(s.substring(i , i + 1));
                int b = Integer.parseInt(s.substring(i - 1 , i ));
                if(count(s , s.charAt(i)) == a && count(s , s.charAt(i - 1)) == b){
                    return s.substring(i - 1, i + 1);
                }
            }
        }
        return "";
    }
    public int count(String s , char ch){
        int co = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(ch == s.charAt(i)){
                co++;
            }
        }
        return co;
    }
}
