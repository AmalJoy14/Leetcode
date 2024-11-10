class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int left1 = 1;
        int left2 = k + 1;
        if (2 * k > nums.size())
            return false;
        if (k == 1)
            return true;
        int count = 1;
        for (int i = 0 ;left2 < nums.size(); i++){
            if (nums.get(left1) > nums.get(left1 - 1) && nums.get(left2) > nums.get(left2 - 1)){
                count++;
            }
            else{
                count = 1;
            }
            if (count == k){
                return true;
            }
            left1++;
            left2++;
        }
        return false;
    }
}
