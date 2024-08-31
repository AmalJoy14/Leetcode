class Solution {
    public int minimum(int a , int b , int c){
        if (a <= b && a <= c){
            return a;
        }
        else if ( b <=a && b <= c){
            return b;
        }
        else{
            return c;
        }
    }
    public int generateKey(int num1, int num2, int num3) {
        int key = 0;
        for (int i = 0 ; i< 4 ; i++){
            int rem1 = num1 % 10;
            int rem2 = num2 % 10;
            int rem3 = num3 % 10;
            num1 = num1 / 10;
            num2 = num2 / 10;
            num3 = num3 / 10;
            int min = minimum(rem1,rem2,rem3);
            key += min*Math.pow(10,i);
        }
        return key;
    }
}
