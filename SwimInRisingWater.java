class Solution {
    public int swimInWater(int[][] grid) {
        int res = Integer.MAX_VALUE;
        int left = 0 , right = grid.length * grid.length - 1 ;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int[][] visited = new int[grid.length][grid.length];
            
            if(isReachable(grid , mid , 0 , 0 , visited)){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
    public boolean isReachable(int[][] grid , int t , int i , int j , int[][] visited){
        int n = grid.length;
        if(i < 0 || j < 0 || i >= n || j >= n || visited[i][j] == 1 || grid[i][j] > t){
            return false;
        }
        //System.out.println(i + " " + j );
        if(i == n - 1 && j == n - 1){
            return true;
        }
        visited[i][j] = 1;
        return isReachable(grid , t , i + 1 , j , visited) || isReachable(grid , t , i - 1 , j , visited) || isReachable(grid , t , i , j + 1, visited) || isReachable(grid , t , i , j - 1, visited) ;
    }
}
