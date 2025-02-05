class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        char c1 = '_', c2 = '_';
        for(int i = 0 ; i < s1.length() ; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1 != ch2){
                if(c1 != '_'){
                    if(c1 != ch2 || c2 != ch1){
                        return false;
                    }
                }
                count++;
                if(count > 2) return false;
                c1 = ch1;
                c2 = ch2;
            }
        }
        if(count == 1)  return false;
        return true;
    }
}
