class Solution {
    int MOD = 1_000_000_007;
    int MAX = 100000;
    public int maximumScore(List<Integer> nums, int k) {
        // Step 1: Compute Smallest Prime Factor (SPF) for fast factorization
        int[] spf = new int[MAX + 1];
        for (int i = 2; i <= MAX; i++) spf[i] = i;
        
        for (int i = 2; i * i <= MAX; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= MAX; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }

        // Step 2: Compute Prime Scores using SPF
        int n = nums.size();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            int count = 0;
            while (num > 1) {
                int prime = spf[num];
                while (num % prime == 0) num /= prime;
                count++;
            }
            scores[i] = count;
        }

        int[] left = new int[n];
        Arrays.fill(left , -1);
        int[] right = new int[n];
        Arrays.fill(right , n);
        Stack<Integer> stk = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!stk.isEmpty() && scores[stk.peek()] < scores[i]){
                int idx = stk.pop();
                right[idx] = i;
            }
            if(!stk.isEmpty())
                left[i] = stk.peek();
            stk.push(i);
        }
       
        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> Integer.compare(b[0] , a[0]));
        for(int i = 0 ; i < n ; i++){
            pq.add(new int[]{nums.get(i) , i });
        }
        long res = 1;
        while(k > 0){
            int[] arr = pq.poll();
            // System.out.println(Arrays.toString(arr));
            long ava = arr[1] - left[arr[1]];
            ava =ava * (right[arr[1]] - arr[1]);
            // System.out.println(ava);
            if(ava >= k){
                res = (res % MOD * modExp(arr[0], k) % MOD) % MOD;
                 k = 0;
            }
            else{
                k -= ava;
                res = (res % MOD * modExp(arr[0], ava) % MOD) % MOD;
            }
        }
        return (int)res;
    }
    public long modExp(long A, long B) {
        long result = 1;
        A %= MOD; 

        while (B > 0) {
            if ((B & 1) == 1) { 
                result = (result * A) % MOD;
            }
            A = (A * A) % MOD; 
            B >>= 1; 
        }
        return result;
    }
}
