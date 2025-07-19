class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime , true);
        isPrime[0] = false;
        if(n >= 2) isPrime[1] = false;
        
        for(int i = 2 ; i * i <= n ; i ++){
            for(int j = i * 2 ; j < n ; j += i){
                isPrime[j] = false;
            }
        }
        //System.out.println(Arrays.toString(isPrime));
        long A = 0 , B = 0;
        for(int i = 0 ; i < n ; i++){
            if(isPrime[i]){
                A += nums[i];
            }
            else{
                B += nums[i];
            }
        }
        return Math.abs(A - B);
    }
}
