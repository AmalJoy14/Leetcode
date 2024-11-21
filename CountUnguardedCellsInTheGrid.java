class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        //Place the guards
        for (int i = 0 ; i < guards.length ; i++){
            grid[guards[i][0]][guards[i][1]] = 3;
        }
        //Place the walls
        for (int i = 0 ; i < walls.length ; i++){
            grid[walls[i][0]][walls[i][1]] = 4;
        }

        //Mark the guarded spots.
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){

                if (grid[i][j] == 3){
                    
                    //Top
                    int k = i - 1;
                    while (k >= 0 && grid[k][j] <= 1){
                        grid[k][j] = 1;
                        k--;
                    }

                    //Bottom
                    k = i + 1;
                    while(k < m && grid[k][j] <= 1){
                        grid[k][j] = 1;
                        k++;
                    }

                    //Left
                    k = j - 1;
                    while(k >= 0 && grid[i][k] <= 1){
                        grid[i][k] = 1;
                        k--;
                    }

                    //Right
                    k = j + 1;
                    while(k < n && grid[i][k] <= 1){
                        grid[i][k] = 1;
                        k++;
                    }
                }

            }
        }
        
        

        //Count the unguarded spots.
        int count = 0;
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j ++){
                if (grid[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }
}
