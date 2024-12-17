class Edge{
    int src;
    int dest;
    int wt;
    Edge(int src, int dest, int wt){
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < times.length ; i++){
            Edge e = new Edge(times[i][0] , times[i][1] , times[i][2]);
            graph[e.src].add(e);
        }

        //DijKstras Algo
        int[] visited = new int[n+1];
        int[] distance = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            if(i != k){
                distance[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.add(new int[]{k , 0});

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            if(visited[arr[0]] != 1){
                visited[arr[0]] = 1;
                for(Edge e: graph[arr[0]]){
                    if(distance[e.src] + e.wt < distance[e.dest]){
                        distance[e.dest] = distance[e.src] + e.wt;
                    }
                    if(visited[e.dest] == 0){
                        pq.add(new int[]{e.dest,distance[e.dest]});
                    }
                    
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= n ; i++){
            max = Math.max(max,distance[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
