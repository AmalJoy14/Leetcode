class Edge{
    int v1;
    int v2;
    Edge(int v1 , int v2){
        this.v1 = v1;
        this.v2 = v2;
    }
}

class Solution {
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i != j){
                    if(intersect(properties[i] , properties[j]) >= k){
                        Edge e = new Edge(i , j);
                        Edge e1 = new Edge(j , i);
                        graph[i].add(e);
                        graph[j].add(e1);
                    }
                }
            }
        }
        int res = 0;
        int[] visited = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(visited[i] == 0){
                dfs(graph , i  , visited);
                res++;
            }
        }
        return res;
    }
    public void dfs(ArrayList<Edge>[] graph , int i ,int[] visited){
        if(visited[i] == 1){
            return;
        }
        visited[i] = 1;
        for(int j = 0 ; j < graph[i].size() ; j++){
            dfs(graph , graph[i].get(j).v2 , visited);
        }
    }
    public int intersect(int[] a , int[] b){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int e : a){
            set.add(e);
        }
        int count = 0;
        for(int e : b){
            set2.add(e);
        }
        for(int e : set){
            if(set2.contains(e)){
                count++;
            }
        }
        return count;
    }
}

