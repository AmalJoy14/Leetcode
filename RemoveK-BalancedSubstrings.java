class Solution {
    public String removeSubstring(String s, int k) {
        Stack<Integer> stk = new Stack<>();
        int open = 0 , close = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                if(close != 0){
                    stk.push(-close);
                    close = 0;
                }
                if(!stk.isEmpty() && stk.peek() > 0){
                    open += stk.pop();
                }
                open++;
                
            }else{
                if(open != 0){
                    stk.push(open);
                    open = 0;
                }
                if(!stk.isEmpty() && stk.peek() < 0){
                    close -= stk.pop();
                }
                close++;
                if(!stk.isEmpty() && close == k && stk.peek() >= k){
                    close = 0;
                    int val = stk.pop() - k;
                    if(val > 0)
                        stk.push(val);
                }
            }
            //System.out.println(stk + " " + open + " " + close);
        }
        if(open > 0) stk.push(open);
        else if(close > 0) stk.push(-close);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < stk.size() ; i++){
            int val = stk.get(i);
            if(val > 0){
                while(val > 0){
                    sb.append('(');
                    val--;
                }
            }else{
                while(val < 0){
                    sb.append(')');
                    val++;
                }
            }
        }
        return String.valueOf(sb);
    }
}
