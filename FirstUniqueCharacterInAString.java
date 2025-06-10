class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr , -1);

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(arr[ch - 'a'] != -1) arr[ch - 'a'] = -404;
            else{
                arr[ch - 'a'] = i;      
            }
        }
        int res = Integer.MAX_VALUE;
        for(int num : arr){
            if(num >= 0) res = Math.min(num , res);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
