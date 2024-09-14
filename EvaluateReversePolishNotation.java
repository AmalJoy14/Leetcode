class Solution {
    public int evalRPN(String[] tokens) {
        Stack <Integer> stk = new Stack<>();
        for (int i = 0 ; i < tokens.length ; i++){

            if (!tokens[i].equals("*") && !tokens[i].equals("/") && !tokens[i].equals("+") && !tokens[i].equals("-")){
                stk.push(Integer.valueOf(tokens[i]));
            }
            else{
                int b = stk.pop();
                int a = stk.pop();
                if (tokens[i].equals("+"))
                    stk.push(a + b);
                else if(tokens[i].equals("-"))
                    stk.push(a - b);
                else if(tokens[i].equals("*"))
                    stk.push(a * b);
                else 
                    stk.push(a / b);
            }
        }
        return stk.pop();
    }
}
