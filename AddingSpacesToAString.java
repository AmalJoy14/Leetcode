class Solution {
    public String addSpaces(String s, int[] spaces) {
        int pointer = 0, i;
        StringBuilder sb = new StringBuilder();
        for (i = 0 ; i < s.length() && pointer < spaces.length; i++){
            while(i != spaces[pointer]){
                sb.append(s.charAt(i));
                i++;
            }
            i--;
            sb.append(" ");
            pointer++;
        }
        while(i < s.length()){
            sb.append(s.charAt(i));
            i++;
        }
        return String.valueOf(sb);
    }
}
