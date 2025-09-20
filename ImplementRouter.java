class Router {
    Queue<int[]> que = null;
    Map<Integer , List<int[]>> map = null;
    Map<Integer , Integer> remCount = null;
    Set<String> set = null;
    int capacity = -1;
    public Router(int memoryLimit) {
        que = new LinkedList<>();
        map = new HashMap<>();
        remCount = new HashMap<>();
        set =new HashSet<>();
        capacity = memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {

        if(!map.containsKey(destination)){
            map.put(destination , new ArrayList<>());
        }
        if(set.contains(source + "#" + destination + "#" + timestamp)){
            return false;
        }
        
        if(que.size() == capacity){
            int[] arr = que.remove();
            int remDest = arr[1];
            remCount.put(remDest , remCount.getOrDefault(remDest, 0) + 1);
            set.remove(arr[0] + "#" + arr[1] + "#" + arr[2]);
        }
        map.get(destination).add(new int[]{source , timestamp});
        que.add(new int[]{source , destination , timestamp});
        set.add(source + "#" + destination + "#" + timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        if(que.isEmpty()){
            return new int[]{};
        }
        int[] arr = que.remove();
        int remDest = arr[1];
        remCount.put(remDest , remCount.getOrDefault(remDest, 0) + 1);
        set.remove(arr[0] + "#" + arr[1] + "#" + arr[2]);
        return arr;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        List<int[]> currQue = map.get(destination);
        if(currQue == null) return 0;
        
        int left = remCount.getOrDefault(destination , 0) , right = currQue.size() - 1;
        //System.out.println(currQue + " " + left) ;
        int start = -1, end = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            int[] arr = currQue.get(mid);
            if(arr[1] >= startTime){
                start = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        left = remCount.getOrDefault(destination , 0) ;
        right = currQue.size() - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            int[] arr = currQue.get(mid);
            if(arr[1] > endTime){
                right = mid - 1;
            }else{
                end = mid;
                left = mid + 1;
            }
        }
        //System.out.println(start + " " + end) ;

        if(start == -1 && end == -1) return 0;
        if(start == -1) start = left;
        if(end == -1) end = left - 1;

        return end - start + 1;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
