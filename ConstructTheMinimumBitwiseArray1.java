class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];

        for (int i = 0 ; i < nums.size() ; i++){
            ans[i] = -1;
            for (int val = 0 ; val < nums.get(i) ; val++){
                if ((val | (val+1)) == nums.get(i)){
                    ans[i] = val;
                    break;
                }
            }
        }
        return ans;
    }
}
