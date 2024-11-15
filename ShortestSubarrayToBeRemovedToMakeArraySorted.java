class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;

        // Find the left bound where the array stops being non-decreasing
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        // If the entire array is already sorted
        if (left == n - 1) {
            return 0;
        }

        // Find the right bound where the array stops being non-decreasing
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // Calculate the minimum length to remove
        int result = Math.min(n - left - 1, right); // Either remove the prefix or suffix

        // Check if we can merge left and right parts
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
