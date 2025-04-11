class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for(int i = low ; i <= high ; i++){
            if(i >= 10 && i <= 99){
                int val = i;
                int rem = i % 10;
                val = val / 10;
                if(val == rem) res++;
            }
            else if( i >= 1000 && i <= 9999){
                int val = i;
                int sum1 = val % 10;
                val = val / 10;
                sum1 += val % 10;
                val = val / 10;
                int sum2 = val % 10;  
                val = val / 10;
                sum2 += val % 10;
                if(sum1 == sum2) res++;
            }
        }
        return res;
    }
}
