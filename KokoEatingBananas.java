class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i = 0 ; i < piles.length ; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }

        // //Brute Force
        // for (int k = 1 ; k <= max ; k++){
        //     int time = 0;
        //     for (int i = 0 ; i < piles.length ; i++){
        //         time += Math.ceil(piles[i] /(double) k);
        //     }
        //     if (time <= h){
        //         return k;
        //     }
        // }
        // return -1;


        //We have k ranging from 1 to max. Use binary Search to find solution to optimize it.
        int left = 1, right = max;
        while(left < right){
            int k = (left + right)/2;
            if (timeNeeded(piles, k) > h ){
                left = k + 1;
            }
            else if (timeNeeded(piles, k) <= h){
                right = k;
            }
        }
        return left;
    }

    public int timeNeeded(int[] piles, int k) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + k - 1) / k;
        }
        
        return time;
    }
}
