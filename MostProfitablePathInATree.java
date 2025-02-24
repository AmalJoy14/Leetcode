class Edge{
    int src;
    int dest;
    Edge(int src , int dest){
        this.src = src;
        this.dest = dest;
    }
}

class Solution {
    int bobc = 1;
    int max = Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        ArrayList<Edge>[] graph = new ArrayList[amount.length];

        int[] visited = new int[amount.length];
        int[] bobcount = new int[amount.length];

        for(int i = 0 ; i < amount.length ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < edges.length ; i++){
            Edge e1 = new Edge(edges[i][0] ,edges[i][1]);
            graph[e1.src].add(e1);
            Edge e2 = new Edge(edges[i][1] ,edges[i][0]);
            graph[e2.src].add(e2);
        }

        bobPath(0 , bob , graph , visited ,bobcount);
        // System.out.println(Arrays.toString(bobcount));
        Arrays.fill(visited , 0);
        maxRes(1 ,0 , graph ,visited ,bobcount , 0 , amount);
        return max;
    }

    public void maxRes(int alice ,int i ,ArrayList<Edge>[] graph , int[] visited , int[] bobcount , int pft , int[] amount){
        if(bobcount[i] > alice || bobcount[i] == 0)
            pft += amount[i];
        else if(bobcount[i] == alice)
            pft += amount[i] / 2;

        if(i != 0 && graph[i].size() == 1){
            max = Math.max(max , pft);
            return;
        }
        if(visited[i] == 0){
            visited[i] = 1;
            
            // System.out.println(i + " " + alice +" " + pft);
            for(int j = 0 ; j < graph[i].size() ; j++){
                int next = graph[i].get(j).dest;
                maxRes(alice + 1 ,next , graph , visited , bobcount , pft, amount);    
            }
        }
    }

    public boolean bobPath(int i , int bob , ArrayList<Edge>[] graph ,int[] visited ,int[] bobcount){
        if(i == bob){
            bobcount[i] = bobc;
            bobc++;
            return true;
        }
        // System.out.println( bob + " " + i + " " + Arrays.toString(bobcount));
        
        if(visited[i] == 0){
            visited[i] = 1;
            for(int j = 0 ; j < graph[i].size() ; j++){
                if(bobPath(graph[i].get(j).dest , bob , graph , visited ,bobcount)){
                    bobcount[i] = bobc;
                    bobc++;
                    return true;
                }
            }
        }
        return false;
    }
}
