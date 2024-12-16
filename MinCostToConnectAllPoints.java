class Edge {
    int src;
    int dest;
    int wt;

    Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph[i].add(new Edge(i, j, cost));
                graph[j].add(new Edge(j, i, cost));
            }
        }

        // Prims Algorithm
        int cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] { 0, 0 });
        int[] visited = new int[n];
        while (!pq.isEmpty()) {
            int[] node = pq.remove();
            if (visited[node[0]] != 1) {
                visited[node[0]] = 1;
                cost += node[1];
                for (int i = 0; i < graph[node[0]].size(); i++) {
                    Edge e = graph[node[0]].get(i);
                    if (visited[e.dest] == 0) {
                        pq.add(new int[] { e.dest, e.wt });
                    }
                }
            }

        }
        return cost;
    }
}
