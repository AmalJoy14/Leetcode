class Solution {
    public String smallestPalindrome(String s) {
        if(s.length() == 1) return s;
        ArrayList<Character> list = new ArrayList<>();
        
        for(int i = 0 ; i < s.length() / 2 ; i++){
          char ch = s.charAt(i);
          list.add(ch);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(char ch : list){
            sb.append(ch);
        }
        if(s.length() % 2 != 0){
            sb.append(s.charAt(s.length() / 2));
        }
        for(int i = list.size() - 1 ; i >= 0 ; i--){
            sb.append(list.get(i));
        }
        return String.valueOf(sb);
    }
}
