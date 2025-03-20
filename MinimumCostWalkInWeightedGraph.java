class Solution {
    
    public int[] minimumCost(int n, int[][] edges, int[][] query) {

        int[] parent = new int[n];
        int[] rank = new int[n];
        int[] cost = new int[n];
        Arrays.fill(cost , -1);
        
        int[] res = new int[query.length];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }

        for(int i = 0 ; i < edges.length ; i++){
            int rootX = find(edges[i][0] , parent);
            int rootY = find(edges[i][1] , parent);
            // if (rootX == rootY) continue;
            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
                cost[rootX] = (cost[rootX] & cost[rootY] & edges[i][2]);
            }
            else if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
                cost[rootY] = (cost[rootX] & cost[rootY] & edges[i][2]);
            }
            else{
                parent[rootX] = rootY;
                rank[rootY]++;
                cost[rootY] = (cost[rootX] & cost[rootY] & edges[i][2]);
            }
            // System.out.println(Arrays.toString(cost));
        }

        for(int i = 0 ; i < query.length ; i++){
            int root0 = find(query[i][0], parent);
            int root1 = find(query[i][1], parent);
            if(root0 != root1){
                res[i] = -1;
            }
            else{
                res[i] = cost[root1];
            }
        }
        
        return res;
    }
    public int find(int x ,int[] parent){
        if(x == parent[x]){
            return x;
        }
        parent[x] = find(parent[x] , parent);
        return parent[x];
    }
}
