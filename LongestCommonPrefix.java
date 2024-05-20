class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s="";
        String first=strs[0];
        for (int i=0;i<first.length();i++){
            for (int j=1;j<strs.length;j++){
                try{
                if (strs[j].charAt(i)!=first.charAt(i)){
                    return s;
                }
                }
                catch(StringIndexOutOfBoundsException e ){
                    return s;
                }
            }
            s=s+first.charAt(i);
        }
        return s;
    }
}
