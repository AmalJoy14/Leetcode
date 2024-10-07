class Solution {
    public int minLength(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0 ; i < s.length() ; i++){
            // System.out.println(stk);
            char ch = s.charAt(i);
            if (!stk.isEmpty()){
                if(stk.peek() == 'A' && s.charAt(i) == 'B'){
                    stk.pop();
                    continue;
                }
                if(stk.peek() == 'C' && s.charAt(i) == 'D'){
                    stk.pop();
                    continue;
                }
            }
            stk.push(s.charAt(i));
            
        }
        return stk.size();
    }
}
