class Solution {
    public int longestPalindrome(String[] words) {
        int flag = 0;
        int[][] box = new int[26][26];
        for(int i = 0 ; i < words.length ; i++){
            String s = words[i];
            char ch1 = s.charAt(0);
            char ch2 = s.charAt(1);
            box[ch1 - 'a'][ch2 - 'a']++;
        }
        int res = 0;
        for(int i = 0 ; i < 26 ; i++){
            for(int j = 0 ; j <= i ; j++){
                if(i == j){
                    res += (box[i][j] / 2) * 4;
                    if(flag == 0)
                        flag = box[i][j] % 2 != 0 ? 2 : 0;
                }
                else
                    res += (int)(Math.min(box[i][j] , box[j][i]) * 4);
            }
        }
        return res + flag;
    }
}
