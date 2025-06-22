class Solution {
    public int minimumDeletions(String word, int k) {
        int[] arr = new int[26];
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            arr[ch - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i < 26 ; i++){
            if(arr[i] == 0) continue;
            int del = 0;
            for(int j = 0 ; j < 26 ; j++){
                if(i == j || arr[j] == 0) continue;
                
                if(arr[j] < arr[i]){
                    del += arr[j];
                }
                else if(arr[j] - arr[i] > k){
                    del += arr[j] - arr[i] - k;
                }
            }
            res = Math.min(del , res);
        }
        return res;
    }
}
