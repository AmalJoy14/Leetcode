class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        int len = s.length;
        if (s[0].charAt(0) != s[len - 1].charAt(s[len-1].length() - 1)){
            return false;
        }
        for (int i = 0 ; i < len-1 ; i++){
            if (s[i].charAt(s[i].length() - 1) != s[i+1].charAt(0)){
                return false;
            }
        }
        return true;
    }
}
