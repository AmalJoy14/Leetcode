class Solution {
    public int maxVowels(String s, int k) {
        int res = 0;
        int left = 0;
        int count = 0;
        for(int right = 0 ; right < s.length() ; right++){
            char ch = s.charAt(right);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
            if(right >= k){
                char ch2 = s.charAt(left);
                if(ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u'){
                    count--;
                }
                left++;
            }
            res = Math.max(res , count);
        }
        return res;
    }
}
