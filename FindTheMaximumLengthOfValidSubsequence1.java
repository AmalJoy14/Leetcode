class Solution {
    public int maximumLength(int[] nums) {
        int odd = 0 , even = 0 , alt = 0;
        int flag = -1;
        for(int num : nums){
            if(num % 2 != flag){
                alt++;
                flag = num % 2;
            }

            if(num % 2 != 0) odd++;
            else even++;
        }
            
        return Math.max(Math.max(odd , even) , alt);
    }
}
