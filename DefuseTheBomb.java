class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length, sum = 0;
        int[] res = new int[n];

        if (k == 0){
            return res;
        }
        else if (k > 0){
            for (int i = 0 ; i <= k ; i++){
                sum += code[i];
            }
            int loc = k + 1;
            for (int i = 0 ; i < n ; i++){
                sum -= code[i];
                res[i] = sum;
                sum += code[loc % n];
                loc++;
            }
        }
        else{
            for (int i = n - 1 ; i >= n + k ; i--){
                sum += code[i];
            }
            int loc = n + k;
            for (int i = 0 ; i < n ; i++){
                res[i] = sum;
                sum -= code[loc % n];
                sum += code[i];
                loc++;
            }
        }
        return res;
    }
}
