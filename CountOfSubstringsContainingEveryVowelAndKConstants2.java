class Solution {
    public long countOfSubstrings(String word, int k) {
        int a = 0 , e = 0 , i = 0 , o = 0 , u = 0 , con = 0;
        int right = 0 , nextCon = -1;
        long res = 0;
        for(int left = 0 ; left < word.length() ; left++){
            
            while(right < word.length() && (a < 1 || e < 1 || i < 1 || o < 1 || u < 1 || con < k)){
                char ch = word.charAt(right);
                if(ch == 'a') a++;
                else if (ch == 'e') e++;
                else if (ch == 'i') i++;
                else if (ch == 'o') o++;
                else if (ch == 'u') u++;
                else con++;
                right++;
            }
            if(a > 0 && e > 0 && i > 0 && o > 0 && u > 0 && con == k){
                if(nextCon < right){
                    nextCon = right;
                    while(nextCon < word.length() && "aeiou".contains(String.valueOf(word.charAt(nextCon)))){
                        nextCon++;
                    }
                }
                if(nextCon < word.length()){
                    res += nextCon - right + 1;
                }
                else{
                    res += word.length() - right + 1;
                }
            }
            char ch2 = word.charAt(left);
            if(ch2 == 'a') a--;
            else if (ch2 == 'e') e--;
            else if (ch2 == 'i') i--;
            else if (ch2 == 'o') o--;
            else if (ch2 == 'u') u--;
            else con--;
        }
        return res;
    }
}
