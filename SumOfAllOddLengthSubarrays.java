class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        /*************Brute Force************ */
        for (int i = 0 ; i < arr.length ; i++){
            for (int j = i ; j < arr.length ; j++){
                if ((i - j)%2 != 0) continue;   //Additional
                for (int k = i ; k <= j ; k++){
                    sum += arr[k];
                }
            }
        }
        return sum;
    }
}
