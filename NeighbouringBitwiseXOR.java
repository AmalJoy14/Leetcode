class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int [] original = new int[n];
        original[0] = 1;
        for(int i = 0 ; i < n - 1 ; i++){
            if(derived[i] == 1){
                if(original[i] != 1){
                    original[i + 1] = 1;
                }
            }
            else{
                if(original[i] == 1){
                    original[i + 1] = 1;
                }
            }
        }
        if(derived[n - 1] == 1){
            if(original[n - 1] == 0){
                return true;
            }
        }
        else{
            if(original[n - 1] == 1 ){
                return true;
            }
        }
        return false;
    }
}
