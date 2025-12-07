class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int[][] grid = new int[n][n];
        int res = 0;
        for(int i = 0 ; i < dig.length ; i++){
            grid[dig[i][0]][dig[i][1]] = 1;
        }
        for(int i = 0 ; i < artifacts.length ; i++){
            int r1 = artifacts[i][0];
            int c1 = artifacts[i][1];
            int r2 = artifacts[i][2];
            int c2 = artifacts[i][3];
            int flag = 1;
            for(int p = r1 ; p <= r2 ; p++){
                for(int q = c1 ; q <= c2 ; q++){
                    if(grid[p][q] == 0){
                        flag = 0;
                        break;
                    }
                }
            }
            if(flag == 1) res++;
        }
        return res;
    }
}
