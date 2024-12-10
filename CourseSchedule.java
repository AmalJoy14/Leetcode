class Edge{
    int src;
    int dest;
    public Edge(int src, int dest){
        this.src = src;
        this.dest = dest;
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Edge>[] graph = new ArrayList[numCourses];

        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < prerequisites.length ; i++){
            Edge e = new Edge(prerequisites[i][1], prerequisites[i][0]);
            graph[e.src].add(e);
        }

        int[] visited = new int[numCourses];

        for (int i = 0 ; i < visited.length ; i++){
            if(visited[i] == 0){
                if(isCyclePresent(graph , visited , i ,new HashSet<>())){
                    return false;
                }
            }
        }
        return true; 
    }

    public boolean isCyclePresent(List<Edge>[] graph, int[] visited , int i ,HashSet<Integer> recStk){
        if(recStk.contains(i)){
            return true;
        }
        if (visited[i] == 1){
            return false;
        }
        visited[i] = 1;

        for(Edge e : graph[i]){
            recStk.add(i);
            if(isCyclePresent(graph , visited , e.dest , recStk)){
                return true;
            }
            recStk.remove(i);
        }

        return false;
    }
}
