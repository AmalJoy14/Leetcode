class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char res = letters[0];
        for(int i = 0 ; i < letters.length ; i++){
            if(target < letters[i]){
                return letters[i];
            }
        }
        return res;
    }
}
