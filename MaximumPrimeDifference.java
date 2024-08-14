class Solution {
    public boolean isPrime(int x){
        if (x == 0 || x == 1) return false;
        for (int i = 2 ; i <= x/2 ; i++){
            if (x % i == 0)
                return false;
        }
        return true;
    }
    public int maximumPrimeDifference(int[] nums) {
        int left = 0, right = nums.length - 1;
        if ((!isPrime(nums[left]) || !isPrime(nums[right])) && nums.length <= 2){
            return 0;
        }

        while (left < right){
            if (isPrime(nums[left])){
                break;
            } else{
                left++;
            }
        }

        while (left <= right){
            if (isPrime(nums[right])){
                break;
            } else{
                right--;
            }
        }
        return right-left;
    }
}
