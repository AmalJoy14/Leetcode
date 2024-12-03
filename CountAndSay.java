class Solution {
    public String countAndSay(int n) {
        
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            StringBuilder sb = new StringBuilder();
            int left = 0,count = 1;
            int right = 0;
            for (right = 0 ; right < s.length() ; right++){
                if(right > 0 && s.charAt(right) == s.charAt(right - 1)){
                    count++;
                }
                else if (right > 0){
                    sb.append(count).append(s.charAt(right - 1));
                    count = 1;
                }
                
            }
            sb.append(count).append(s.charAt(right - 1));
            s = String.valueOf(sb);
            
        }
        return s;
    }
}
