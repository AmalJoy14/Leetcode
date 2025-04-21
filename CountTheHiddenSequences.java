class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int max = 0 , min = 0 , op = 0 , n = differences.length;
        for(int i = 0 ; i <  n ; i++){
            op += differences[i];
            max = Math.max(max , op);
            min = Math.min(min , op);
        }
        int val = lower , res = 0;

        while(val <= upper){
            int temp = val;
            if((temp + max) <= upper && (temp + min) >= lower){
                res++;
            }
            val++;
        }
        return res;
    }
}
