class Solution {
    public int balancedString(String s) {
        int  n = s.length();
        int Q = 0 , W = 0 , E = 0 , R = 0;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == 'Q') Q++;
            else if(ch == 'W') W++;
            else if(ch == 'E') E++;
            else R++;
        }
        int sub = n / 4;
        Q -= sub;
        W -= sub;
        E -= sub;
        R -= sub;
        if(Q <= 0 && W <= 0 && E <= 0 && R <= 0) return 0;

        int q = 0 , w = 0 , e = 0 , r = 0 , res = Integer.MAX_VALUE;
        int left = 0;
        for(int right = 0 ; right < n ; right++){
            char ch = s.charAt(right);
            if(ch == 'Q') q++;
            else if(ch == 'W') w++;
            else if(ch == 'E') e++;
            else r++;
            
            while (left < n && Q <= q && W <= w && E <= e && R <= r) {
                res = Math.min(res , right - left + 1);
                ch = s.charAt(left);
                if(ch == 'Q') q--;
                else if(ch == 'W') w--;
                else if(ch == 'E') e--;
                else r--;
                left++;
            }
        }
        return res;
    }
}
