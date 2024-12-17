class Solution {
    int[] parent ; 
    int[] rank ; 
    int[] res = new int[2];
    int flag = 0;

    //Path Compression
    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }
            else if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }
            else{
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
        else{
            res[0] = x;
            res[1] = y;
            flag = 1;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        //Union Find
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
        for(int i = 1; i <= n ; i++){
            parent[i] = i;
        }

        for(int i = 0 ; i < n ; i++){
            union(edges[i][0] , edges[i][1]);
            if(flag == 1){
                return res;
            }
        }
        return res;
    }

}
