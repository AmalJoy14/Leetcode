class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String res = "";
        int min = Math.min(str1.length() , str2.length());
        for(int i = 0 ; i < min ; i++){
            String s = str1.substring(0 , i + 1);
            int flag = 1;
            for(int j = 0; j < str1.length() ; j += i + 1){
                if(j + i + 1 > str1.length() || !str1.substring(j , j + i + 1).equals(s)){
                    flag = 0;
                    break;
                }
            }
            if(flag == 0) continue;
            for(int j = 0; j < str2.length() ; j += i + 1){
                if(j + i + 1 > str2.length() || !str2.substring(j , j + i + 1).equals(s)){
                    flag = 0;
                    break;
                }
            }
            if(flag == 0) continue;
            res = s;
        }
        return res;
    }
}
