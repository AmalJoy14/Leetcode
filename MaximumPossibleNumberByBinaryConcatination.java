class Solution {
    public int maxGoodNumber(int[] nums) {
        // Convert each number to its binary representation
        String[] binaryStrings = new String[3];
        for (int i = 0; i < nums.length; i++) {
            binaryStrings[i] = Integer.toBinaryString(nums[i]);
        }

        List<String> permutations = new ArrayList<>();
        generatePermutations(binaryStrings, 0, permutations);

        int maxBinaryValue = 0;
        for (String perm : permutations) {
            int value = Integer.parseInt(perm, 2);
            maxBinaryValue = Math.max(maxBinaryValue, value);
        }

        return maxBinaryValue;
    }

    private void generatePermutations(String[] binaryStrings, int currentIndex, List<String> permutations) {
        if (currentIndex == binaryStrings.length) {
            permutations.add(String.join("", binaryStrings));
            return;
        }
        for (int i = currentIndex; i < binaryStrings.length; i++) {
            swap(binaryStrings, currentIndex, i);
            generatePermutations(binaryStrings, currentIndex + 1, permutations);
            swap(binaryStrings, currentIndex, i); // backtrack
        }
    }

    private void swap(String[] array, int firstIndex, int secondIndex) {
        String temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
