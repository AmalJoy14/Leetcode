class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long res1 = 0 , res2 = 0;
        int n = text.length();
        char ch1 = pattern.charAt(0) , ch2 = pattern.charAt(1);
        long[] sufix = new long[n];
        long[] prefix = new long[n];
        long sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(text.charAt(i) == ch1){
                sum++;
            }
            prefix[i] = sum;
        }
        if(ch1 == ch2) {
            return sum * (sum + 1) / 2;
        }
        sum = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            if(text.charAt(i) == ch2){
                sum++;
            }
            sufix[i] = sum;
        }
        
        for(int i = n - 1; i >= 0; i--){
            char ch = text.charAt(i);
            if(ch == ch2){
                res1 += prefix[i] + 1;
            }
        }
        
        for(int i= 0 ;i < n ; i++){
            char ch = text.charAt(i);
            if(ch == ch1){
                res2 += sufix[i] + 1;
            }
        }
        return Math.max(res1 , res2);
    }
}
