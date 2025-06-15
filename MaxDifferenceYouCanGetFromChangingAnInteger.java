class Solution {
    public int maxDiff(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int min = 0 , max = 0 , dig = -1;
        if(sb.charAt(0) - '0' > 1){
            dig = sb.charAt(0) - '0';
            for(int i = 0 ; i < sb.length() ; i++){
                if(sb.charAt(i) - '0' == dig){
                    sb.setCharAt(i , '1');
                }
            } 
        }
        else{
            for(int i = 0 ; i < sb.length() ; i++){
                if(dig == -1 && sb.charAt(i) - '0' > 1){
                    dig = sb.charAt(i) - '0';
                }
                if(sb.charAt(i) - '0' == dig){
                    sb.setCharAt(i , '0');
                }
            } 
        }
        min = Integer.parseInt(String.valueOf(sb));
        
        sb = new StringBuilder(String.valueOf(num));
        dig = -1;
        for(int i = 0 ; i < sb.length() ; i++){
            if(dig == -1 && sb.charAt(i) != '9'){
                dig = sb.charAt(i) - '0';
            }
            if(dig != -1 && sb.charAt(i) - '0' == dig){
                sb.setCharAt(i , '9');
            }
        }
        max = Integer.parseInt(String.valueOf(sb));
        return max - min;
    }
}
