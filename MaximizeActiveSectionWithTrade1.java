class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int count = 0 , res = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '1'){
                count++;
            }
        }
        res = count;
        int k = 0;
        for( k = 0 ; k < s.length() && s.charAt(k) == '1' ; k++);
        for(int i = k ; i < s.length() ; i++){
            int left = -1 , right = -1;
            char ch = s.charAt(i);
            if(ch == '1'){
                left = i;
                while(i < s.length() && s.charAt(i) == '1'){
                    i++;
                }
                if(i == s.length())break;
                right = i - 1;
                int val = right - left + 1;
                left--;
                while(left >= 0 && s.charAt(left) == '0') left--;
                left++;
                right++;
                while(right <s.length() && s.charAt(right) == '0') right++;
                right--;
                
                res = Math.max(res , count - val + right - left + 1);
            }
            
        }
        return res;
    }
}
