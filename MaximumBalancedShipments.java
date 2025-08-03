class Solution {
    public int maxBalancedShipments(int[] weight) {
        int max = -1, n = weight.length , res = 0;
        for(int i = 0; i < n ; i++){
            max = Math.max(weight[i] , max);
            if(max > weight[i]){
                res++;
                max = -1;
            }
        }
        return res;
    }
}
