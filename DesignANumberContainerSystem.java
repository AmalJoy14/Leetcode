class NumberContainers {
    HashMap<Integer , PriorityQueue<Integer>> val = null;
    HashMap<Integer , Integer> indexMap = null;


    public NumberContainers() {
        val = new HashMap<>();
        indexMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        indexMap.put(index , number);
        if(val.get(number) == null){
            val.put(number , new PriorityQueue<>());
        }
        val.get(number).add(index);
    }
    
    public int find(int number) {
        PriorityQueue<Integer> currpq = val.get(number);
        if(currpq == null) return -1;
        while(!currpq.isEmpty()){
            int idx = currpq.peek();
            if(indexMap.get(idx) == number){
                return idx;
            }
            currpq.poll();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
