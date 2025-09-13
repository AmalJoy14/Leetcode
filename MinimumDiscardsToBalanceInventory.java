class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int n = arrivals.length;
        Map<Integer , Integer> map = new HashMap<>();
        int left = 0, count = 0;
        for(int right = 0 ; right < n ; right++){
            if(right - left + 1 > w){
                map.put(arrivals[left] , map.getOrDefault(arrivals[left] , 0) - 1);
                left++;
            }
            int curr = map.getOrDefault(arrivals[right] , 0);
            if(curr == m){
                count++;
                arrivals[right] = -1;
                map.put(-1 , map.getOrDefault(-1, 0) + 1);
            }else{
                map.put(arrivals[right] , map.getOrDefault(arrivals[right] , 0 ) + 1);
            }
        }
        return count;
    }
}
