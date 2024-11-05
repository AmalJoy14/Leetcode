class Solution {
    public int balancedStringSplit(String s) {
        int left = 0 ,count = 0;
        int l = 0, r = 0;
        for (int right = 0 ; right < s.length() ; right++){
            if (s.charAt(right) == 'L'){
                l++;
            } else {
                r++;
            }

            if ( l == r){
                count++;
                l = 0;
                r = 0;
                left = right;
            }
        }
        return count;
    }
}
