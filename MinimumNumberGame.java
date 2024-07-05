class Solution {
    public int[] numberGame(int[] nums) {
        int[] arr = new int[nums.length];

        Arrays.sort(nums);
        for (int i=0 ; i<nums.length-1 ;i++){
            arr[i+1] = nums[i];
            arr[i] = nums[i+1];
            i++;
        }
        return arr;
    }
}
