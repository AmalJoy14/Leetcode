class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0 , sumEven = 0;
        int i = 1;
        while(n > 0){
            sumOdd += i++;
            sumEven += i++;
            n--;
        }
        return gcd(sumOdd , sumEven);
    }
    public int gcd(int a , int b){
        if(a == 0){
            return b;
        }
        return gcd(b % a,  a);
    }
}
