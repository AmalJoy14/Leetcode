class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] smallestEq = new int[26];
        for(int i = 0 ; i < 26 ; i++) smallestEq[i] = i;

        for(int i = 0 ; i < s1.length() ; i++){
            int ch1 = s1.charAt(i) - 'a';
            int ch2 = s2.charAt(i) - 'a';

            int min = Math.min(smallestEq[ch1] , smallestEq[ch2]);
            int max = Math.max(smallestEq[ch1] , smallestEq[ch2]);
            
            for(int j = 0 ; j < 26 ; j++){
                if(smallestEq[j] == max)  smallestEq[j] = min;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < baseStr.length() ; i++){
            int ch = baseStr.charAt(i) - 'a';
            char resChar = (char)(smallestEq[ch] + 'a');
            sb.append(resChar);
        }
        return String.valueOf(sb);
    }
}
