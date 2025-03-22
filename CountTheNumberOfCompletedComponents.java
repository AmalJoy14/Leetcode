class Edge{
    int v1 ;
    int v2 ;
    Edge(int v1 ,int v2){
        this.v1 = v1; 
        this.v2 = v2;
    }
}

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int res = 0;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<Edge>();
        }
        
        for(int i = 0 ; i < edges.length ; i++){
            Edge e = new Edge(edges[i][0] , edges[i][1]);
            graph[e.v1].add(e);
            graph[e.v2].add(e);
        }
        // System.out.println(graph[0]);
        int[] visited = new int[n];
        for(int i = 0 ; i < n ; i++){
            HashSet<Integer> set = new HashSet<>();
            int vertices = countVertices(i , graph , set , visited);
            int edgesCount = set.size();
            if(vertices != 0 && edgesCount == vertices *(int) (vertices - 1) /2.0 ){
                res++;
            } 
        }
        return res;
    }
    public int countVertices(int i , ArrayList<Edge>[] graph , HashSet<Integer> set , int[] visited){
        if(visited[i] == 1){
            return 0;
        }
        visited[i] = 1;
        int count = 0;
        for(int j = 0 ; j < graph[i].size() ; j++){
            Edge e = graph[i].get(j);
            int next = e.v2 == i ? e.v1 : e.v2;
            int min = Math.min(next , i);
            int max = Math.max(next , i);
            set.add(min * 100 + max);
            count += countVertices(next , graph , set , visited);
        }
        return 1 + count;
    }
}
