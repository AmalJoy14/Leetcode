class Solution {
    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>();
        char[] vowels = new char[]{'a','e','i','o','u','A','E','I','O','U'};
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            for(char v : vowels){
                if(v == ch){
                    list.add(ch);
                    break;
                }
            }
        }
        Collections.sort(list);
        int idx = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            int flag = 0;
            for(char v : vowels){
                if(v == ch){
                    sb.append(list.get(idx++));
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                sb.append(ch);
            }
        }
        return String.valueOf(sb);
    }
}
