class Solution {
    public String smallestString(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < s.length()){
            if(s.charAt(idx) == 'a'){
                sb.append('a');
                idx++;
            }
            else break;
        }
        if(idx == s.length()) return s.substring(0 , idx - 1) + "z";
        int flag = 0;
        
        for(int i = idx ;i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == 'a'){
                flag = 1;
            }
            if(flag == 0){
                sb.append(--ch);
            }else{
                sb.append(ch);
            }
        }
        return String.valueOf(sb);
    }
}
