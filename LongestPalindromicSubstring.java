class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        String max = "";

        if (len == 1){
            return s.substring(0,1);
        }
        
        int mid1 = 0;
        for (int mid2 = 1; mid2 < len; mid2++) {
            
            // Palindrome is of even length.
            if (s.charAt(mid1) == s.charAt(mid2)) {
                int left = mid1, right = mid2;
                while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                if (s.substring(left + 1, right).length() > max.length()) {
                    max = s.substring(left + 1, right);
                }
            }

            // Palindrome is of odd length.
             
                int left = mid1, right = mid1;
                while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                if (s.substring(left + 1, right).length() > max.length()) {
                    max = s.substring(left + 1, right);
                }
            
            mid1++;
        }

        return max;
    }
}
