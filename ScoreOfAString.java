class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i=1; i<s.length(); i++){
           int diff = Math.abs(s.charAt(i - 1) - s.charAt(i));
            sum += diff;
        }
        return sum;
    }
}
