class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[][] dp = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            Arrays.fill(dp[i] , -1);
        }
        int k = 0;
        for(int i = row - 1 ; i >= 0 ; i--){
            for(int j = col - 1 - k ; j >= 0 ; j--){
                if(i == row - 1){
                    dp[i][j] =  triangle.get(i).get(j);
                }
                else{
                    int left = Integer.MAX_VALUE , right = Integer.MAX_VALUE;

                    left = dp[i + 1][j];
                    
                    right = dp[i + 1][j + 1];
                    
                    
                    dp[i][j] = triangle.get(i).get(j) + Math.min(left , right);
                }
                
            }
            k++;
        }
        return dp[0][0];
    }
}
