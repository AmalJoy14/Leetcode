class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        for(int i = 0 ; i < graph[0].length ; i++){
            ArrayList<Integer> sublist = new ArrayList<>();
            sublist.add(0);
            findPath(graph , sublist , graph[0][i]);
        }
        return list;
    }
    public void findPath(int[][] graph , List<Integer> sublist , int curr){
        if(curr == graph.length - 1){
            sublist.add(curr);
            list.add(sublist);
            return;
        }
        for(int i = 0 ; i < graph[curr].length ; i++){
            ArrayList<Integer> newsublist = new ArrayList<>(sublist);
            newsublist.add(curr);
            findPath(graph , newsublist , graph[curr][i]);
        }
    }
}
