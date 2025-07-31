class Solution {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        while(sb.length() != 1){
            int size = sb.length();
            if(sb.charAt(size - 1) == '0'){
                sb.deleteCharAt(size - 1);
            }else{
                add(sb);
            }
            count++;
        }
        return count;
    }
    public void add(StringBuilder sb){
        int i;
        for(i = sb.length() - 1 ; i >= 0 && sb.charAt(i) == '1'; i--){
            sb.setCharAt(i , '0');
        }
        if(i == -1){
            sb.insert(0 , '1');
        }else{
            sb.setCharAt(i , '1');
        }
    }
}
