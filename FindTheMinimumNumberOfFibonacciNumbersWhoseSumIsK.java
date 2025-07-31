class Solution {
    public int findMinFibonacciNumbers(int k) {
        if(k == 2) return 1;
        ArrayList<Integer> list = new ArrayList<>();

        int a = 0 , b = 1 , c = 1;
        while(c <= k){
            list.add(c);
            c = a + b;
            a = b;
            b = c;
        }
        int res = 0;
        for(int i = list.size() - 1; i >= 0 ; i--){
            if(list.get(i) <= k){
                k -= list.get(i);
                res++;
            }
        }
        
        return res;
    }
}
