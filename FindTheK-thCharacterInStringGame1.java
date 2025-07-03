class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        while(sb.length() < k){
            int size = sb.length();
            for(int i = 0 ; i < size ; i++){
                char ch = sb.charAt(i);
                ch++;
                ch %= 'z';
                sb.append(ch);
            }
        }
        return (char)sb.charAt(k - 1);
    }
}
