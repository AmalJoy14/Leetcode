class Solution {
    public int minimumLength(String s) {
        int len = s.length();
        int[] arr = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            int ch = s.charAt(i) - 'a';
            arr[ch]++;
        }
        int res = 0;
        for(int i = 0 ; i< 26 ; i++){
            if(arr[i] > 2){
                if(arr[i] % 2 != 0){
                    res += 1;
                }
                else{
                    res += 2;
                }
            }
            else{
                res += arr[i];
            } 
        }
        return res;
    }
}
