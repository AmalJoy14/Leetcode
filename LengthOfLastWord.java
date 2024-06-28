class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int start = s.length()-1;
        while(s.charAt(start) == ' '){
            start--;
        }
        for (int i = start ; i>=0 && s.charAt(i) != ' ' ; i--){
            count ++;
        }
        return count;
    }
}
