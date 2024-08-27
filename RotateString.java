class Solution {
    public boolean rotateString(String s, String goal) {
        int len = goal.length();
        if (s.length() != len) return false;
        StringBuilder sb = new StringBuilder(goal);
        for (int i = 0 ; i < len ; i++){
            String rem = sb.substring(len - 1,len);
            sb.deleteCharAt(len - 1);
            sb.insert(0,rem);
            if (String.valueOf(sb).equals(s)){
                return true;
            }
        }
        return false;
    }
}
