class Solution {
    public int[] minOperations(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 1 ; i <= 8191 ; i++){
            if(isPalindrome(i)){
                set.add(i);
            }
        }
        for(int i = 0 ; i < nums.length; i++){
            if(isPalindrome(nums[i])){
               nums[i] = 0;   
            }
            else{
                nums[i] = Math.min(Math.abs(nums[i] - set.ceiling(nums[i]) ),Math.abs(nums[i] - set.floor(nums[i])));
            }
        }
        return nums;
    }
    public boolean isPalindrome(int num){
        String s = Integer.toBinaryString(num);
        int n = s.length();
        for(int i = 0 ; i < n / 2 ; i++){
            if(s.charAt(i) != s.charAt(n - i - 1)) return false;
        }
        return true;
        
    }
}
