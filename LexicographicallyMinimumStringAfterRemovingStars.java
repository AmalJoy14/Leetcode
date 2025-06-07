class Solution {
    public String clearStars(String s) {
        Stack<Integer>[] arr = new Stack[26];
        for(int i = 0 ; i < 26 ; i++){
            arr[i] = new Stack<>();
        }
        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                for(int j = 0 ; j < 26 ; j++){
                    if(!arr[j].isEmpty()){
                        set.add(arr[j].pop());
                        break;
                    }
                }
            }
            else{
                arr[ch - 'a'].push(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            if(!set.contains(i) && s.charAt(i) != '*'){
                sb.append(s.charAt(i));
            }
        }
        return String.valueOf(sb);
    }
}
