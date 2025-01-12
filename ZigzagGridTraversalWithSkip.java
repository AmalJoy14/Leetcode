class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        int m = grid.length , n = grid[0].length;
        int flag = 0 , j = 0;
        for(int i = 0 ; i < m ; i++){
            
            if(j == 0){
                while(j < n){
                    if(flag == 0){
                        list.add(grid[i][j]);
                        flag = 1;
                    }
                    else{
                        flag = 0;
                    }
                    j++;
                }
            }
            else if(j == n - 1){
                while(j >= 0){
                    if(flag == 0){
                        list.add(grid[i][j]);
                        flag = 1;
                    }
                    else{
                        flag = 0;
                    }
                    j--;
                }
            }
            if(j == n){
                j = n - 1;
            }
            else if(j == -1){
                j = 0;
            }
        }
        return list;
    }
}
