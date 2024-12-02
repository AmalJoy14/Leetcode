class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        for (int i = 0 ; i < arr.length ; i++){
            int flag = 0;
            if (arr[i].length() < searchWord.length()){
                continue;
            }
            for (int j = 0 ; j < searchWord.length(); j++){
                if (arr[i].charAt(j) != searchWord.charAt(j)){
                    flag = 1;
                }
            }
            if (flag == 0) return i+1;
        }
        return -1;
    }
}
