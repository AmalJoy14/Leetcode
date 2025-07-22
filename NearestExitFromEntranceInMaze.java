class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{entrance[0] , entrance[1] , 0});
        int m = maze.length , n = maze[0].length;
        maze[entrance[0]][entrance[1]] = '+';
        

        while(!que.isEmpty()){
            int[] curr = que.remove();
            int i = curr[0];
            int j = curr[1];
            
            if((i != entrance[0] || j != entrance[1]) && (i == 0 || i == m - 1 || j == 0 || j == n - 1)){
                return curr[2];
            }
            int val = curr[2] + 1;
            
            if(i > 0 && maze[i - 1][j] != '+'){
                que.add(new int[]{i - 1 , j , val});
                maze[i - 1][j] = '+';
            }
            if(j > 0 && maze[i][j - 1] != '+'){
                que.add(new int[]{i , j - 1, val});
                maze[i][j - 1] = '+';
            }
            if(i < m - 1 && maze[i + 1][j] != '+'){
                que.add(new int[]{i + 1, j, val});
                maze[i + 1][j] = '+';
            }
            if(j < n - 1 && maze[i][j + 1] != '+'){
                que.add(new int[]{i , j + 1, val});
                maze[i][j + 1] = '+';
            }
        }
        return -1;
    }
}
