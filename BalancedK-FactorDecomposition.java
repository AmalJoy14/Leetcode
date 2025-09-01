class Solution {
    int bestDiff = Integer.MAX_VALUE;
    List<Integer> best = new ArrayList<>();
    public int[] minDifference(int n, int k) {
        
        
        //System.out.println(list);
        minimizeDifference(n , k , 1 , new ArrayList<>());
        
        int[] res = new int[k];
        for(int i = 0 ; i < k ; i++){
            res[i] = best.get(i);
        }
        return res;
    }
    public void minimizeDifference(int n , int k , int st , List<Integer> sub){
        if(k == 1 && n >= st){
            sub.add(n);
            int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
            for(int num : sub){
                max = Math.max(num , max);
                min = Math.min(num , min);
            }
            int diff = max - min;
            if(diff < bestDiff){
                bestDiff = diff;
                best = new ArrayList<>(sub);
            }
            sub.remove(sub.size() - 1);
            return;
        }

        for(int i = st ; i <= n ; i++){
            if(n % i == 0){
                sub.add(i);
                minimizeDifference(n / i , k - 1 , i , sub);
                sub.remove(sub.size() - 1);
            }
        }
        
    }
}©leetcode
