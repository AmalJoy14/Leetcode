class Solution {
    public boolean checkPowersOfThree(int n) {
        HashSet<Integer> set = new HashSet<>();
        
        while(true){
            int res = -1;
            for(int i = 0 ; i < 20 ; i++){
                int val = (int)Math.pow(3 , i);
                if(val > n || set.contains(val)){
                    break;
                }
                else if(!set.contains(val)){
                    res = val;
                }
            }
            
            set.add(res);
            if(res != -1)
                n -= res;
            else
                break;
        }
        return n == 0;
    }
}
