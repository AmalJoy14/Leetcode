class Solution {
    public int maxFreqSum(String s) {
        int[] arr = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }
        int maxv = 0 , maxc = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(i == 0 || i == 4 ||i == 8 || i == 14 ||i == 20){
                maxv = Math.max(maxv , arr[i]);
            }else{
                maxc = Math.max(maxc , arr[i]);
            }
        }
        return maxv + maxc;
    }
}
