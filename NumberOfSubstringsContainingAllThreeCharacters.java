class Solution {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int a = 0 , b = 0 , c = 0 , right = 0;
        for(int left = 0 ; left < s.length() ; left++){
            while(right < s.length() && (a < 1 || b < 1 || c < 1)){
                char ch = s.charAt(right);
                right++;
                if(ch == 'a') a++;
                else if(ch == 'b') b++;
                else c++;
            }
            if(a > 0 && b > 0 && c > 0){
                res += s.length() - right + 1;
            }
            char ch = s.charAt(left);
            if(ch == 'a') a--;
            else if(ch == 'b') b--;
            else c--;
        }
        return res;
    }
}
