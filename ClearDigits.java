class Solution {
    public String clearDigits(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i  = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                stk.pop();
            }
            else{
                stk.push(ch);
            }
        }
        for(char ch : stk){
            sb.append(ch);
        }
        return String.valueOf(sb);
    }
}
