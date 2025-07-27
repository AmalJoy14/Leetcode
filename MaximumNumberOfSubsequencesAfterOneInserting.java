class Solution {
    public long numOfSubsequences(String s) {
        int n = s.length();
        long[] prefixL = new long[n + 1];
        long[] suffixT = new long[n + 1];
        for(int i = 0 ; i < n ; i++){
            prefixL[i + 1] = prefixL[i] + (s.charAt(i) == 'L' ? 1 : 0);
        }
        for(int i = n- 1 ; i >= 0 ; i--){
            suffixT[i] = suffixT[i + 1] + (s.charAt(i) == 'T' ? 1: 0);
        }
        long baseLCT = 0;
        long addC = 0;
        long addL = 0;
        long addT = 0;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == 'L'){
                addC = Math.max((prefixL[i] + 1) * suffixT[i + 1] , addC);
            }
            else if(s.charAt(i) == 'T'){
                addC = Math.max((prefixL[i]) * (suffixT[i + 1] + 1) , addC);
            }
            if(s.charAt(i) == 'C'){
                baseLCT += prefixL[i] * suffixT[i + 1];
                addL += suffixT[i + 1];
                addT += prefixL[i];
            }
        }
        return baseLCT + Math.max(addL , Math.max(addT , addC));
    }
}
