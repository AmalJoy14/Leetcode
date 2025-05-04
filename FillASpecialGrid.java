class Solution {
    int strt = 0;
    public int[][] specialGrid(int N) {
        if(N == 0) return new int[][]{{0}};
        int n = (int)Math.pow(2 , N);
        int m = n * n;
        int [][] res = new int[n][n];
        
        fillval( res , 0 , 0 , n );
        return res;
    }
    public void fillval(int[][] res , int r , int c , int size ){
        if(size == 1){
            res[r][c] = strt;
            strt++;
            return;
        }
        int halfsize = size / 2;
        int supersize = size / 2 * size / 2;
        fillval( res , r , c + halfsize ,halfsize);
        fillval( res , r  + halfsize, c + halfsize ,halfsize);
        fillval( res , r + halfsize, c ,halfsize);
        fillval( res , r, c ,halfsize);
        
    }
}
