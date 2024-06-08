class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i<accounts.length ; i++){
            int singleCusWealth = 0;
            for (int j = 0 ; j< accounts[i].length ; j++){
                singleCusWealth += accounts[i][j];
            }
            if (max < singleCusWealth){
                max = singleCusWealth;
            }
        }
        return max;
    }
}
