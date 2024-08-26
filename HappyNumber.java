class Solution {
    public boolean isHappy(int n) {
        HashSet <Integer> set = new HashSet<>();
        while (true){
            int sqr = 0;
            while(n != 0){
                int rem = n % 10;
                sqr += Math.pow(rem, 2);
                n = n/10;
            }
            if (sqr == 1) return true;
            if (set.contains(sqr))
                return false;
            else 
                set.add(sqr);
            n = sqr;
            
        }
    }
}
