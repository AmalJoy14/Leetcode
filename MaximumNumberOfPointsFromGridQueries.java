class Solution {
    PriorityQueue<int[]> deque = new PriorityQueue<>((a , b) -> Integer.compare(a[2] , b[2]));
    public int[] maxPoints(int[][] grid, int[] queries) {
        ArrayList<int[]> list = new ArrayList<>();
        int n = queries.length;
        for(int i = 0 ; i < n ; i++){
            list.add(new int[]{queries[i] , i});
        }
        Collections.sort(list , (a , b) -> Integer.compare(a[0] , b[0]));
        int[] answer = new int[n];
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] added = new int [grid.length][grid[0].length];
        
        int cost = 0;
        added[0][0] = 1;
        deque.add(new int[]{0 , 0 , grid[0][0]});
        for(int i = 0 ; i < n ; i++){
            
            while(!deque.isEmpty() && deque.peek()[2] < list.get(i)[0]){
                int[] arr = deque.poll();
                cost += dfs(arr[0] , arr[1] , grid , visited, list.get(i)[0] , added);
            }
            answer[list.get(i)[1]] = cost;
        }
        return answer;
    }
    public int dfs(int i , int j , int[][] grid , int[][] visited , int val , int[][] added){

        if(i == -1 || j == -1 || i == grid.length || j == grid[0].length){
            return 0;
        }
        if(visited[i][j] == 1){
            return 0;
        }
        if(val <= grid[i][j]){
            if(added[i][j] == 0){
                deque.add(new int[]{i , j , grid[i][j]});
                added[i][j] = 1;
            }
            return 0;
        }
        visited[i][j] = 1;

        int left = dfs(i , j - 1 , grid , visited , val, added);
        int right = dfs( i  , j + 1 , grid , visited , val, added);
        int top = dfs(i - 1 , j  , grid , visited , val, added);
        int bottom = dfs(i + 1 , j  , grid , visited , val, added);

        return 1 + left + right + top + bottom;
    }
}
