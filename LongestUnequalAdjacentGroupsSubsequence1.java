class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> list = new ArrayList<>();
        int flag = -1;
        for(int i = 0 ; i < words.length ; i++){
            if(flag == -1){
                list.add(words[i]);
                flag = groups[i];
            }
            else if(flag == 0 && groups[i] == 1){
                flag = 1;
                list.add(words[i]);
            }
            else if(flag == 1 && groups[i] == 0){
                flag = 0;
                list.add(words[i]);
            }
        }
        return list;
    }
}
