class Solution {
    public int countCollisions(String directions) {
        int n = directions.length(), res = 0;
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0 ; i < n ; i++){
            char ch = directions.charAt(i);
            if(stk.isEmpty()){
                stk.push(ch);
            }else{
                char prev = stk.peek();
                if(ch == 'L'){
                    if(prev == 'S'){
                        res++;
                    }else if(prev == 'R'){
                        stk.pop();
                        res += 2;
                        while(!stk.isEmpty() && stk.peek() == 'R'){
                            stk.pop();
                            res++;
                        }
                        stk.push('S');
                    }
                }else if(ch == 'R'){
                    stk.push('R');
                }else {
                    while(!stk.isEmpty() && stk.peek() == 'R'){
                        stk.pop();
                        res++;
                    }
                    stk.push('S');
                }
            }
            //System.out.println(stk + " " + res);
        }
        return res;
    }
}
