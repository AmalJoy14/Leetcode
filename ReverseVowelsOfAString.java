class Solution {
    public String reverseVowels(String s) {
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ;i < s1.length() ; i++){
            if ("aeiouAEIOU".contains(String.valueOf(s1.charAt(i)))){
                sb.append(String.valueOf(s1.charAt(i)));
                s1.replace(i,i+1,"~");
            }
        }
        String rev = String.valueOf(sb.reverse());
        int j = 0;
        for (int i = 0 ;i < s1.length() ; i++){
            if(s1.charAt(i) == '~'){
                s1.replace(i,i+1,String.valueOf(rev.charAt(j)));
                j++;
            }
        }
        return String.valueOf(s1);
    }
}
