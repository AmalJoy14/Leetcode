class Solution {
    public int countSubstrings(String s) {
        int j = 1,count = 0;
        for(int i = 0 ; i < s.length() ; i++){

            //Odd Length Palindrome
            int left = i, right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }

            //Even Length Palindrome
            if(j < s.length() && s.charAt(i) == s.charAt(j)){

                left = i;
                right = j;
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    count++;
                    left--;
                    right++;
                }
            }
            j++;
        }
        return count;
    }
}
