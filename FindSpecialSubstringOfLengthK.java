class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int size = 1;
        if(s.length() == 1)return true;
        for(int i = 1 ; i < s.length() ; i++){
            int flag = 0;
            while(i < s.length() && s.charAt(i - 1) == s.charAt(i)){
                size++;
                i++;
                flag = 1;
            }
            if(flag == 1) i--;
            if(size == k) return true;
            
            size = 1;
        }
        return false;
    }
}
