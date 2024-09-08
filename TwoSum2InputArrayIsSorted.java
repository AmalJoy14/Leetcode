class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0 ,right = numbers.length - 1;
        while (numbers[left] + numbers[right] != target){
            int sum = numbers[left] + numbers[right];
            if (sum > target)
                right--;
            else if (sum < target)
                left++;
        }
        return new int[]{left + 1, right + 1};
    }
}
