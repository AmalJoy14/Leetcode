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
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            Edge e = new Edge(flights[i][0], flights[i][1], flights[i][2]);
            graph[e.src].add(e);
        }

        // Dijkstra's algorithm
        Queue<int[]> que = new LinkedList<>();
        int[] dist = new int[n];
        int[] subdist = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
                subdist[i] = dist[i];
            }
        }

        que.add(new int[] { src, 0 });
        que.add(null);
        while (!que.isEmpty()) {
            int[] arr = que.remove();

            for (int i = 0; i < graph[arr[0]].size(); i++) {
                Edge e = graph[arr[0]].get(i);
                if (dist[e.src] + e.wt < subdist[e.dest]) {
                    subdist[e.dest] = dist[e.src] + e.wt;
                    que.add(new int[] { e.dest, dist[e.dest] });
                }
            }

            if (que.peek() == null) {
                for (int i = 0; i < n; i++) {
                    dist[i] = subdist[i];
                }
                
                que.remove();
                k--;
                if (k == -1)
                    break;
                if (!que.isEmpty()) {
                    que.add(null);
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
