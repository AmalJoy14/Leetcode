class Edge {
    int src;
    int dest;

    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        int[] bfsed = new int[n + 1];
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new Edge(edges[i][0], edges[i][1]));
            graph[edges[i][1]].add(new Edge(edges[i][1], edges[i][0]));
        }
        int res = 0;
        int[] color = new int[n + 1];
        for (int i = 1; i <= n; i++) {

            if (bfsed[i] == 0) {
                if (hasOddCycle(i, graph, color)) {
                    return -1; // Return -1 if an odd cycle is found
                }

                Queue<Integer> sameComp =  new LinkedList<>();
                dfs(i, graph,sameComp, new int[n + 1]);
                int currentMax = 0;
                while (!sameComp.isEmpty()) {
                    int curr = sameComp.remove();
                    bfsed[curr] = 1;
                    currentMax = Math.max(currentMax, bfs(curr, graph, new int[n + 1]));
                }
                res += currentMax;
            }
        }
        return res;
    }

    public void dfs(int i, ArrayList<Edge>[] graph, Queue<Integer> que, int[] visited) {
        if (visited[i] == 1) {
            return;
        }
        visited[i] = 1;
        que.add(i);
        for (int j = 0; j < graph[i].size(); j++) {
            Edge e = graph[i].get(j);
            if (visited[e.dest] != 1)
                dfs(e.dest, graph, que, visited);
        }
    }

    public int bfs(int start, ArrayList<Edge>[] graph, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        int levels = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            levels++;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                for (Edge edge : graph[node]) {
                    int neighbor = edge.dest;
                    if (visited[neighbor] == 0) {
                        queue.add(neighbor);
                        visited[neighbor] = 1;
                    }
                }
            }
        }

        return levels; 
    }

    public boolean hasOddCycle(int start, ArrayList<Edge>[] graph, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1; // Start coloring with 1

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Edge edge : graph[node]) {
                int neighbor = edge.dest;

                if (color[neighbor] == 0) { 
                    // Assign opposite color
                    color[neighbor] = -color[node]; 
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) { 
                    // Found an odd cycle
                    return true;
                }
            }
        }
        return false; // No odd cycle detected
    }
}
