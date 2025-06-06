class Solution {
    public String robotWithString(String s) {
        int[] count = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder t = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int len = -1 , idx = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            while(count[idx] == 0){
                idx++;
            }

            while(len > -1 && t.charAt(len) <= ch && t.charAt(len) <= idx + 'a') {
                res.append(t.charAt(len));
                t.deleteCharAt(len);
                len--;
            }
            
            if(idx == ch - 'a'){
                res.append(ch);
            }
            else{
                t.append(ch);
                len++;
            }
            count[ch - 'a']--;
           //System.out.println(i + " " + t + " " + res);
            
        }
        
        res.append(t.reverse());
        
        return String.valueOf(res);
    }
}
