class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] firstIdx = new int[26];
        Arrays.fill(firstIdx , -1);
        int[] lastIdx = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            int ch = s.charAt(i) - 'a';
            if(firstIdx[ch] == -1){
                firstIdx[ch] = i;
            }
            lastIdx[ch] = i;
        }
        int count = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(firstIdx[i] != -1 && lastIdx[i] != firstIdx[i]){
                HashSet<Character> set = new HashSet<>();
                for(int j = firstIdx[i] + 1; j < lastIdx[i] ; j++){
                    set.add(s.charAt(j));
                }
                count += set.size();
            }
        }
        return count;
    }
}
