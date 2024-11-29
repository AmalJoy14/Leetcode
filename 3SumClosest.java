class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE, diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            while (i > 0 && i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }

            int left = i + 1, right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);
                if (Math.abs(sum - target) < diff) {
                    closest = sum;
                    diff = Math.abs(sum - target);
                }

                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return closest;
    }
}
