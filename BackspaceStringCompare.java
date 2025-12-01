class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1 , j = t.length() - 1;
        int skip1 = 0 , skip2 = 0, flag = 0;
        while(i >= 0 || j >= 0){
            flag = 0;
            while(i >= 0 && (s.charAt(i) == '#' || skip1 > 0)) {
                if(s.charAt(i) == '#') skip1++;
                else if(skip1 > 0) skip1--;
                i--;
                flag = 1; 
            }
            
            while(j >= 0 && (t.charAt(j) == '#' || skip2 > 0)) {
                if(t.charAt(j) == '#') skip2++;
                else if(skip2 > 0) skip2--;
                j--;
                flag = 1;
            }
            if(i >= 0 && j >= 0){
                if( s.charAt(i) != t.charAt(j)) return false;
                else {
                    i--;
                    j--;
                }
                flag = 1;
            }
            if(flag == 0) return false;
        }
        if(i == -1 && j == -1)return true;
        else return false;
    }
}
