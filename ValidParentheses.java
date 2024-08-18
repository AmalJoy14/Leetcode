class Solution {
    public boolean isValid(String s) {
        Stack <Character> stk = new Stack<>();
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')  return false;
        stk.push(s.charAt(0));
        for (int i = 1 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                stk.push(ch);
            else if (stk.size() == 0) return false;
            else if (ch == ')'){
                if (stk.pop() != '(') return false;
            }  
            else if (ch == ']'){
                if (stk.pop() != '[') return false;
            }   
            else if (ch == '}'){
                if (stk.pop() != '{') return false;
            }
        }
        return (stk.size() == 0);
    }
}
