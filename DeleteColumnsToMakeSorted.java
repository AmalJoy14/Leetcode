class Solution {
    public int minDeletionSize(String[] strs) {
        int del = 0;
        for(int j = 0 ; j < strs[0].length() ; j++){
            char curr = 'a'; 
            for(int i = 0 ; i < strs.length ; i++){
                if(strs[i].charAt(j) < curr){
                    del++;
                    break;
                }else{
                    curr = strs[i].charAt(j);
                }
            }
        }
        return del;
    }
}
