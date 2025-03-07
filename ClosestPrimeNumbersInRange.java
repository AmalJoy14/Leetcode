class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] res = new int[]{-1 , -1};
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime , true);

        isPrime[1] = false;

        for(int i = 2 ; i*i < right + 1; i++){
            if(isPrime[i] == true){
                for(int j = i * 2 ; j <= right ; j += i){
                    isPrime[j] = false;
                }
            }
        }
        int curr = Integer.MAX_VALUE;
        Queue<Integer> que = new LinkedList<>();
        for(int i = left ; i <= right ; i++){
            if(isPrime[i]){
                que.add(i);
            }
        }
        // System.out.println(que);
        int a = -1;
        if(que.isEmpty()){
            return res;
        }else{
            a = que.remove();
        }

        while(!que.isEmpty()){
            int b = que.remove();
            if(b - a < curr){
                curr = b - a;
                res[0] = a;
                res[1] = b;
            }
            a = b;
        }
        return res;
    }
}
