class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int res = 0;
        int[] left = new int[n];
        for(int i = 0 ; i < n ; i++){
            int j = 0;
            for( j = 0 ; j < n ; j++){
                if(left[j] != 1 && baskets[j] >= fruits[i]){
                    left[j] = 1;
                    break;
                }
            }
            if(j == n){
                res++;
            }
        }
        return res;
    }
}
