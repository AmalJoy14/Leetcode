class Solution {
    public String removeStars(String s) {
        Stack<Character> stk  = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch != '*'){
                stk.push(ch);
            }
            else{
                stk.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < stk.size() ; i++){
            sb.append(stk.get(i));
        }
        return String.valueOf(sb);
    }
}
