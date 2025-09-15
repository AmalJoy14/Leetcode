class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        int count = 0;
        int[] broken = new int[26];
        for(int i = 0 ; i < brokenLetters.length() ; i++){
            char ch = brokenLetters.charAt(i);
            broken[ch - 'a']++;
        }
        for(int i = 0 ; i < arr.length ; i++){
            int isbroken = 1;
            for(int j = 0 ; j < arr[i].length(); j++){
                char ch = arr[i].charAt(j);
                if(broken[ch - 'a'] == 1){
                    isbroken = 0;
                    break;
                }
            }
            count += isbroken;
        }
        return count;
    }
}
