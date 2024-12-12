class Edge{
    int src;
    int dest;
    Edge (int src ,int dest){
        this.src = src;
        this.dest = dest;
    }
}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        ArrayList<Edge>[] newgraph = new ArrayList[graph.length];
        for(int i = 0 ; i < graph.length ; i++){
            newgraph[i] = new ArrayList<>();
        }
        for (int i = 0 ; i < graph.length ; i++){
            for(int dest : graph[i]){
                Edge e = new Edge(i ,dest);
                newgraph[i].add(e);
            }
        }

        int[] visited = new int[graph.length];
        HashSet<Integer> set = new HashSet<>();
        int[] hasLoops = new int[graph.length];

        for(int i = 0 ; i < visited.length ; i++){
            if(visited[i] == 0){
                hasCycle(visited , i , newgraph , hasLoops, set);
            }
        }
        for(int i = 0 ; i < hasLoops.length ; i++){
            if(hasLoops[i]== 0){
                res.add(i);
            }
        }
        return res;
    }

    public boolean hasCycle(int[] visited, int i, ArrayList<Edge>[] graph, int[] hasLoops, HashSet<Integer> set){
        if(set.contains(i)){
            hasLoops[i] = 1;
            return true;
        }
        if(visited[i] == 1){
            if (hasLoops[i] == 1){
                return true;
            }
            else{
                return false;
            }
        }
        visited[i] = 1;

        for(Edge e : graph[i]){
            set.add(e.src);
            if(hasCycle(visited , e.dest, graph, hasLoops, set)){
                hasLoops[i] = 1;
                set.remove(e.src);
                return true;
            }
            set.remove(e.src);
        }
        return false;
    }
}
