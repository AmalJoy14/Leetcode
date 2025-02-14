class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        int n = asteroids.length;
        for(int i = 0 ; i < n ; i++){
            // System.out.println(stk);
            if(asteroids[i] > 0){
                stk.push(asteroids[i]);
            }
            else{
                if(stk.isEmpty()){
                    stk.push(asteroids[i]);
                }
                else{
                    if(stk.peek() < 0){
                        stk.push(asteroids[i]);
                    }
                    else{
                        int flag = 0;
                        while(!stk.isEmpty() && stk.peek() > 0 && stk.peek() <= (-asteroids[i])){
                            if(stk.pop() == (-asteroids[i])){
                                flag = 1;
                                break;
                            }
                        }
                        if(flag == 1) continue;
                        if(stk.isEmpty() || stk.peek() < 0){
                            stk.push(asteroids[i]);
                        }
                    }
                }
            }
        }
        int[] res = new int[stk.size()];
        for (int i = 0 ; i < stk.size() ; i++){
            res[i] = stk.get(i);
        }
        return res;
    }
}
