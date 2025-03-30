class Solution {
    public int longestPalindrome(String s, String t) {
        String res1 = "" , res2 = "";
        String res = "";
        //Check empty also
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i ; j <= s.length() ; j++){
                res1 = s.substring(i , j );
                
                    for(int p = 0 ; p < t.length() ; p++){
                        for(int q = p ; q <= t.length() ; q++){
                            res2 = t.substring(p , q );
                            
                                String val = res1 + res2;
                                if(isPalindrome(val)){
                                    if(val.length() > res.length()){
                                        res = val;
                                    }
                                }
                            
                        }
                    }
                
            }
        }
        return res.length();
    }
    public boolean isPalindrome(String s){
        if(s.length() <= 1)return true;
        for(int i = 0 ; i < s.length() / 2 ; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
