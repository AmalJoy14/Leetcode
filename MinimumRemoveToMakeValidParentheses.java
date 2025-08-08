class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                if(!stk.isEmpty() && s.charAt(stk.peek()) == '('){
                    stk.pop();
                }
                else{
                    stk.push(i);
                }
            }else if(ch == '('){
                stk.push(i);
            }
        }
        stk.push(Integer.MAX_VALUE);
        int idx = stk.get(0) , j = 0;
        for(int i = 0 ; i < s.length() ;i++){
            if(i != idx){
                sb.append(s.charAt(i));
            }else{
                j++;
                idx = stk.get(j);
            }
        }
        return String.valueOf(sb);   
    }
}
