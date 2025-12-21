class Solution {
    public int minOperations(String s) {
        int[] arr = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            arr[s.charAt(i) - 'a'] = 1;
        }
        int res = 0;
        for(int i = 1 ; i < 26 ; i++){
            if(arr[i] == 1){
                return 26 - i; 
            }
        }
        
        return res;
    }
}
