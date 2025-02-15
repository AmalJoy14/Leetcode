class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for(int i = 1 ; i <= n ; i++){
            if((i % 9 ==0 || i % 9 == 1) && check( i , i * i , 0)){
                res += i*i;
            }
        }
        return res;
    }
    public boolean check(int num , int sq ,int  sum){
        if(sum == num && sq == 0) return true;
        if(sq == 0) return false;

        int n = String.valueOf(sq).length();
        for(int i = 1 ; i <= n ; i++){
            if(check(num , sq / (int)Math.pow(10 , i) , sum + (int) (sq % (Math.pow(10 , i))))){
                return true;
            }
        }
        return false;
    }
}
