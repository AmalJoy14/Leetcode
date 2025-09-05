class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int k = 0 ; k <= 60 ; k++){
            long S = (long)num1 - k * (long)num2;
            if(S < k) continue;
            int count = 0;
            while(S > 0){
                count += S & 1;
                S >>= 1; 
            }
            if(count <= k) return k;
        }
        return -1;
    }
}
