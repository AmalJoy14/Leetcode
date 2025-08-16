class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            graph.get(u).add(new int[]{v , wt});
            graph.get(v).add(new int[]{u , wt + wt});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1] , b[1]));
        pq.add(new int[]{0 , 0});

        int[] visited = new int[n];
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[0] = 0;

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int u = arr[0];
            if(u == n - 1) break;
            int currWt = arr[1];
            visited[u] = 1;
            List<int[]> neighbours = graph.get(u);
            
            for(int i = 0 ; i < neighbours.size() ; i++){
                int[] neighbour = neighbours.get(i);
                int v = neighbour[0];
                int wt = neighbour[1];
                if(visited[v] == 0){
                    if(currWt + wt < dist[v]){
                        dist[v] = currWt + wt;
                        pq.add(new int[]{v , dist[v]});
                    }
                }
            }
        }
        if(dist[n - 1] == Integer.MAX_VALUE) return -1;
        return dist[n - 1];
    }
}
