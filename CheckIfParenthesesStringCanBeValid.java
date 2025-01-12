class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length() % 2 != 0) return false;
        int open = 0 , closed = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(' || locked.charAt(i) == '0'){
                open++;
            }
            else {
                open--;
            }
            if(open < 0) return false;
        }
        for(int i = s.length() - 1 ; i>=0 ; i--){
            if(s.charAt(i) == ')' || locked.charAt(i) == '0'){
                closed++;
            }
            else {
                closed--;
            }
            if(closed < 0) return false;
        }
        return true;
    }
}
