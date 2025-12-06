class Solution {
    public boolean completePrime(int num) {
        int number = num , rev = 0 , mul = 1;
        while(number != 0){
            int rem = number % 10;
            number /= 10;
            rev += rem * mul;
            mul *= 10;
            if(!isPrime(rev)) return false;
        }
        number = num;
        rev = 0;
        while(number != 0){
            mul /= 10;
            int rem = number / mul;
            number %= mul;
            rev = rev * 10 + rem; 
            if(!isPrime(rev)) return false;
        }
        return true;
    }
    public boolean isPrime(int rev){
        if(rev == 2) return true;
        if(rev <= 1) return false;
        if(rev % 2 == 0) return false;

        for(int i = 3 ; i <= Math.sqrt(rev) ; i += 2){
            if(rev % i == 0) return false;
        }
        return true;
    }
}
