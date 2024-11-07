class Solution {
    public int largestCombination(int[] candidates) {
        int max = 0;
        int[] arr = new int[32];
        for (int candidate : candidates) {
            int index = 0;
            while (candidate != 0) {
                if ((candidate & 1) == 1) {  // Check if the least significant bit is set
                    arr[index]++;
                }
                index++;
                candidate >>= 1;  // Right-shift to check the next bit
            }
        }
       for (int count : arr) {
            max = Math.max(max, count);
        }
        return max;

    }
}
