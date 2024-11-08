class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] answer = new int[nums.length];
        int x = 0;
        
        // Calculate the mask with all bits set within maximumBit
        int maxVal = (1 << maximumBit) - 1;

        for (int i = 0; i < nums.length; i++) {
            x ^= nums[i]; // Update cumulative XOR
            answer[nums.length - 1 - i] = x ^ maxVal; // Compute max XOR and store in reverse
        }

        return answer;
    }
}
