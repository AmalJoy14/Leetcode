class Solution {
    int MOD = 1_000_000_007;
    public int specialTriplets(int[] nums) {
        long res = 0;
        int[] map1 = new int[100001];
        int[] map2 = new int[100001];
        for(int i = 1 ; i < nums.length ; i++){
            map1[nums[i]]++;
        }
        map2[nums[0]]++;
        for(int i = 1 ; i < nums.length - 1 ; i++){
            int curr = nums[i];
            map1[curr]--;
            if(curr * 2 <= 100000)
                res = (res + (long)map1[curr * 2] * map2[curr * 2]) % MOD;
            map2[curr]++;
        }
        return (int)res;
    }
}
