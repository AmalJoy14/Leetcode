class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        int sum = 0;
        int[] map = new int[101];
        for(int i = 0 ; i < nums.length ; i ++){
            map[nums[i]]++;
        }
        for(int i = 1 ; i < 101 ; i++){
            if(map[i] % k == 0){
                sum += map[i] * i;
            }
        }
        return sum;
    }
}
