class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1_000_000_007;
        int[] arr = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }
        for(int i = 0 ; i < t ; i++){
            int prev = arr[0];
            for(int j = 1 ; j < 26 ; j++){
                int temp = arr[j];
                arr[j] = prev;
                prev = temp;
            }
            arr[0] = prev;
            arr[1] = (arr[1] + prev) % MOD; 
        }
        int sum = 0;
        for(int val : arr){
            sum = (sum + val) % MOD;
        }
        return sum;
    }
}
