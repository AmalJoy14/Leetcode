class Solution {
    public int fibo(int a,int b, int n){
        int c = a + b;
        if (n == 0) 
            return c;
        
        return fibo(b , c , n -1);
    } 
    public int climbStairs(int n) {
        if (n == 1) return 1; 
        //Fibonacci Series
        int a = 0 , b = 1;
        return fibo( b,a + b, n-2);
    }
}
