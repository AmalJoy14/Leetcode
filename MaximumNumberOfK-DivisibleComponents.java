class Edge {
    int src;
    int dest;

    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

class Solution {
    int count = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            Edge e1 = new Edge(edges[i][0], edges[i][1]);
            graph[e1.src].add(e1);
            Edge e2 = new Edge(edges[i][1], edges[i][0]);
            graph[e2.src].add(e2);
        }
        
        dfs(graph, 0, 0, values, k , -1);
        return count;
    }

    public long dfs(ArrayList<Edge>[] graph, int i, long sum, int[] values, int k , int parent) {
        
        for (int j = 0; j < graph[i].size(); j++) {
            Edge e = graph[i].get(j);
            if(e.dest != parent){
                sum += dfs(graph, e.dest, 0, values, k , i);
            }
            
        }

        sum += values[i];
        if(sum % k == 0){
            count++;
        }
        return sum;
    }
}
