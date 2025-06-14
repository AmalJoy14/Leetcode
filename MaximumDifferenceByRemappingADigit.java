class Solution {
    public int minMaxDifference(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int min = 0 , max = 0 , dig = -1;
        dig = sb.charAt(0) - '0';
        for(int i = 0 ; i < sb.length() ; i++){
            if(sb.charAt(i) - '0' == dig){
                sb.setCharAt(i , '0');
            }
        }
        min = Integer.parseInt(String.valueOf(sb));
        
        sb = new StringBuilder(String.valueOf(num));
        dig = -1;
        //System.out.println(sb);
        for(int i = 0 ; i < sb.length() ; i++){
            if(dig == -1 && sb.charAt(i) != '9'){
                dig = sb.charAt(i) - '0';
            }
            if(dig != -1 && sb.charAt(i) - '0' == dig){
                sb.setCharAt(i , '9');
            }
        }
        max = Integer.parseInt(String.valueOf(sb));
        //System.out.println(max);
        return max - min;
    }
}
