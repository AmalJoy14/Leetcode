class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length() , idx = 0 , i;
        int flag = n % k == 0 ? 0 : 1;
        String[] res = new String[n / k + flag];
        for( i = 0 ; i <= n - k ; i += k){
            res[idx] = s.substring(i , i + k);
            idx++;
        }
        if(flag == 1){
            res[idx] = s.substring(i , n) + String.valueOf(fill).repeat(k - n % k);
        }
        return res;
    }
}
