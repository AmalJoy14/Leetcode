class Solution {
    public boolean scoreBalance(String s) {
        int n = s.length();
        int[] sufix = new int[n];
        int sum = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            sum += s.charAt(i) - 'a' + 1;
            sufix[i] = sum;
        }
        sum = 0;
        for(int i = 0 ; i < n - 1 ;i++){
            sum += s.charAt(i) - 'a' + 1;
            if(sum == sufix[i + 1]) return true;
        }
        return false;
    }
}
