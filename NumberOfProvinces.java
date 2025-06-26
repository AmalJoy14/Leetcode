class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n + 1];
        for(int i = 0 ; i <= n ; i++){
            parent[i] = i;
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(isConnected[i][j] == 1){
                    union(i + 1 , j + 1 , parent);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 1 ; i <= n ; i++){
            int val = find(parent[i], parent);
            set.add(val);
        }
        //System.out.println(Arrays.toString(parent));
        return set.size();
    }
    public void union(int x , int y , int[] parent){
        int X = find(x , parent);
        int Y = find(y , parent);
        parent[X] = Y;
    }
    public int find(int x , int[] parent){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x] , parent);
    }
}
