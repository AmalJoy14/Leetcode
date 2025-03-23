class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int maxDeck = n * n;
        int count = 0 , wt = 0;
        for( count = 0 ; wt <= maxWeight && count <= maxDeck ; count++){
            wt += w;
            // System.out.println(wt);
        }
        // if(count == maxDeck + 1){
        //     count = maxDeck;
        // }
        return count - 1;
    }
}
