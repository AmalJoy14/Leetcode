class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i = 0 ; i < s.length() ; i++){
            int ch = s.charAt(i) - 'a';
            sum += (i + 1) * (26 - ch);
        }
        return sum;
    }
}
