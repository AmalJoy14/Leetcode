class Solution {
    int[] parent = null;
    int extraWires = 0;
    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        for(int i = 0 ; i < connections.length ; i++){
            union(connections[i][0] , connections[i][1]);
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            int par = find(parent[i]);
            set.add(par);
        }
        int req = set.size() - 1;
        if(extraWires < req){
            return -1;
        }
        else{
            return req;
        }
        

    }
    public void union(int x , int y){
        int X = find(x);
        int Y = find(y);
        if(X == Y){
            extraWires++;
        }
        else if(X <= Y){
            parent[Y] = X;
        }
        else{
            parent[X] = Y;
        }
    }
    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
