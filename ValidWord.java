class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        ArrayList<Character> arr = new ArrayList<>(List.of('a' , 'e' , 'i', 'o' , 'u' ,'A','E','I','O','U'));
        boolean hasV = false , hasC = false;
        for(int i = 0 ;i < word.length() ; i++){
            char ch = word.charAt(i);
            if(ch >= '0' && ch <= '9'){
                continue;
            }
            else if( ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z'){
                if(arr.contains(ch)){
                    hasV =true;
                }
                else{
                    hasC = true;
                }
            }
            else {
                return false;
            }
        }
        return hasC && hasV;
    }
}
