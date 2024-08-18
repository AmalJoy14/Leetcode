class Solution {
    public int[] counting(String s){
        int one = 0 , zero = 0;
        for (int i = 0 ; i<s.length() ; i++){
            if (s.charAt(i) == '1')   one++;
            else zero++;
        }
        return new int[]{zero,one};
    }
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length(), p = 0;
        String[] sub = new String[n*(n+1)/2];
        for (int i = 0 ; i<n ; i++){
            for (int j = i; j < n ; j++){
                StringBuilder sb = new StringBuilder();
                for (int l = i;l<=j ; l++){
                    sb.append(s.substring(l,l+1));
                }
                sub[p] = String.valueOf(sb);
                p++;
            }
        }
        int count = 0;
        for (int i = 0 ; i< sub.length ; i++){
            int[] arr = counting(sub[i]);
            if (arr[0] <= k || arr[1] <= k)
                count++;
        }
        return count;
    }
}
