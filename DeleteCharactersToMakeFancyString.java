class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1, i;
        for ( i = 0 ; i < s.length() - 1 ; i++){
            char ch = s.charAt(i);
            if (ch == s.charAt(i+1)){
                count++;
                if (count > 3){
                    count = 3;
                }
            }
            else{
                count = 1;
            }
            if (count != 3){
                sb.append(ch);
            }
        }
        sb.append(s.charAt(i));   
        return String.valueOf(sb);
    }
}
