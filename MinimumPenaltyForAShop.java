class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] yes = new int[n];
        int[] no = new int[n];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(customers.charAt(i) == 'N'){
                count++;
            }
            no[i] = count;
        }
        count = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            if(customers.charAt(i) == 'Y'){
                count++;
            }
            yes[i] = count;
        }
        int res = yes[0], result = 0;
        for(int i = 1 ; i < n ; i++){
            if(res > yes[i] + no[i - 1]){
                res = yes[i] + no[i - 1];
                result = i;
            }
        }
        if(res > no[n - 1]){
            res = no[n - 1];
            result = n;
        }
        return result;
    }
}
