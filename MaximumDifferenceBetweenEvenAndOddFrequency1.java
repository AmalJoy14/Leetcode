class Solution {
    public int maxDifference(String s) {
        int[] arr = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }
        Arrays.sort(arr );
        
        int res = -1,odd = 0 , even = 0;
        for(int i = 25 ; i >= 0 ; i--){
            if(arr[i] % 2 != 0){
                odd = arr[i];
                break;
            }
        }
        for(int i = 0 ; i < 26 ; i++){
            if(arr[i] % 2 ==0 && arr[i] != 0){
                even = arr[i];
                break;
            }
        }
        res = odd - even;
        return res;
    }
}
