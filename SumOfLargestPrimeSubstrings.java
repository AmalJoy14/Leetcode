class Solution {
    public long sumOfLargestPrimes(String s) {
        int n = s.length();
        long res = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = i ; j < n ; j++){
                sb.append(s.charAt(j));
                long val = Long.parseLong(String.valueOf(sb));
                if(!set.contains(val)){
                    
                    set.add(val);
                    if(isPrime(val)){
                        if(pq.size() == 3){
                            if(pq.peek() < val){
                                pq.poll();
                                pq.add(val);
                            }
                        }
                        else{
                            pq.add(val);
                        }
                    }
                }
            }
        }
        while(!pq.isEmpty()){
            res += pq.poll();
        }
        return res;
    }
    public boolean isPrime(long val){
        if(val < 2) return false;
        if(val == 2) return true;
        if(val % 2 == 0) return false;
        for(long i = 3 ; i * i <= val ; i += 2){
            if(val % i == 0) return false;
        }
        return true;
    }
}
