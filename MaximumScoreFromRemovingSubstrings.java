class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stk = new Stack<>();
        Stack<Character> stk1 = new Stack<>();
        int res = 0 , n = s.length();
        stk.push('z');
        stk1.push('z');
        if(x >= y){
            for(int i = 0 ; i < n ; i++){
                char ch = s.charAt(i);
                if(ch == 'b' && stk.peek() == 'a'){
                    res += x;
                    stk.pop();
                }
                else{
                    stk.push(ch);
                }
            }
            for(int i = 0 ; i < stk.size(); i++){
                char ch = stk.get(i);
                if(ch == 'a' && stk1.peek() == 'b'){
                    res += y;
                    stk1.pop();
                }
                else{
                    stk1.push(ch);
                }
            }
            return res;
        }

        else{
            for(int i = 0 ; i < n ; i++){
                char ch = s.charAt(i);
                if(ch == 'a' && stk.peek() == 'b'){
                    res += y;
                    stk.pop();
                }
                else{
                    stk.push(ch);
                }
            }
            for(int i = 0 ; i < stk.size(); i++){
                char ch = stk.get(i);
                if(ch == 'b' && stk1.peek() == 'a'){
                    res += x;
                    stk1.pop();
                }
                else{
                    stk1.push(ch);
                }
            }
            return res;
        }
    }
}
