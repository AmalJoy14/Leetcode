class Solution {
    public int maxLength(int[] nums) {
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int gcd = nums[i];
            long pdt = 1 , lcm = nums[i] ;
            for (int j = i ; j < nums.length ; j++){
                pdt = nums[j] * pdt;
                gcd = gcd ( Math.max(gcd , nums[j]) , Math.min(gcd , nums[j]));
                lcm = LCM(lcm, nums[j]);
                // System.out.println("heyy " + pdt + " " + lcm + " " + gcd);
                if(pdt == lcm * gcd){
                    // System.out.println(i + " " + j);
                    count = Math.max(j - i + 1,count);
                }
                
            }
        }
        return count;
    }

    public int gcd(int a, int b){
        return b == 0 ? a : gcd(b , a % b);
    }
    public long LCM(long a, long b) {
        long max = Math.max(a, b);
        long lcm = max;
        while (lcm % a != 0 || lcm % b != 0) {
            lcm += max;
        }
        return lcm;
    }
}
