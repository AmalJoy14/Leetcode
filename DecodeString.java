class Solution {
    public String decodeString(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch == '['){
                stk.push(ch);
            }
            else if (ch == ']'){
                StringBuilder word = new StringBuilder();
                while(stk.peek() != '['){
                    word.insert(0,stk.pop());
                }
                stk.pop();

                StringBuilder num = new StringBuilder();
                while(stk.size() != 0 &&  (stk.peek() >='0' && stk.peek() <='9')){
                    num.insert(0,stk.pop());
                }
                if (num.equals(""))
                    num.append("1");
                int n = Integer.parseInt(String.valueOf(num));
                String abc = String.valueOf(word).repeat(n);
                for (int j = 0 ; j < abc.length() ; j++){
                    stk.push(abc.charAt(j));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < stk.size() ; i++){
            sb.append(stk.get(i));
        }
        return String.valueOf(sb);
    }
}
