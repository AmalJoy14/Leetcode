class Pair{
    String value;
    int timestamp;
    Pair(String val , int time){
        value = val;
        timestamp = time;
    }
}

class TimeMap {
    HashMap<String , ArrayList<Pair>> map = null;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key , new ArrayList<>());
            map.get(key).add(new Pair(value , timestamp));
        }
        else{
            map.get(key).add(new Pair(value , timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        // System.out.println(map);
        if(!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);
        int left = 0 , right = list.size() - 1;
        int res = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(list.get(mid).timestamp <= timestamp){
                res = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        if(res == - 1) return "";
        return list.get(res).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
