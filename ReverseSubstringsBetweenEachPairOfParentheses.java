class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                StringBuilder revsb = new StringBuilder();
                while(stk.peek() != '('){
                    revsb.append(stk.pop());
                }
                stk.pop();
                for(int j = 0 ; j < revsb.length() ; j++){
                    stk.push(revsb.charAt(j));
                }
            }else{
                stk.push(ch);
            }
        }
        for(int i = 0 ; i < stk.size() ; i++){
            sb.append(stk.get(i));
        }
        return String.valueOf(sb);
    }
}
