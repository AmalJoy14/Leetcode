class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()){
            return true;
        }
        int j = 0;
        for (int i = 0 ; i < t.length() ; i ++){
            char ch1 = s.charAt(j);
            char ch2 = t.charAt(i);
            if (ch1 == ch2){
                j++;
            }
            if(j == s.length()){
                return true;
            }
        }
        return false;
    }
}
