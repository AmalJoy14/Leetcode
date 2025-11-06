class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int countOp1 = 0 , idx = 0;
        for(int i = 0 ; i < queries.length ; i++){
            if(queries[i][0] == 1) countOp1++;
        }
        List<List<Integer>> graph = new ArrayList<>();
        int[] res = new int[countOp1];
        int[] visited = new int[c + 1];
        for(int i = 0 ;i <= c ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < connections.length ; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 1 ; i <= c ; i++){
            if(visited[i] == 0){
                dfs(i , graph ,visited , map , new PriorityQueue<>());
            }
        }
        Set<Integer> offline = new HashSet<>();
        for(int i = 0 ; i < queries.length ; i++){
            int opr = queries[i][0];
            int station = queries[i][1];
            if(opr == 2){
                offline.add(station);
            }else{
                if(!offline.contains(station)){
                    res[idx++] = station;
                    continue;
                }
                PriorityQueue<Integer> pq = map.get(station);
                while(!pq.isEmpty() && offline.contains(pq.peek())){
                    pq.poll();
                }
                if(pq.isEmpty()){
                    res[idx++] = -1;
                }else{
                    res[idx++] = pq.peek();
                }
            }
        }
        return res;
    }
    public void dfs(int i , List<List<Integer>> graph , int[] visited , Map<Integer,PriorityQueue<Integer>> map , PriorityQueue<Integer> pq){
        if(visited[i] == 1){
            return;
        }
        visited[i] = 1;
        pq.add(i);
        map.put(i , pq);
        List<Integer> neighbours = graph.get(i);
        for(int neighbour : neighbours){
            dfs(neighbour , graph , visited , map , pq);
        }
    }
}
