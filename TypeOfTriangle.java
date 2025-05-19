class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0] , b = nums[1] , c = nums[2];
        Arrays.sort(nums);
        if(nums[0] + nums[1] <= nums[2]) return "none";
        
        if(a == b && b == c){
            return "equilateral";
        }
        else if(a != b && b != c && a != c){
            return "scalene";
        }
        else{
            return "isosceles";
        }
    }
}
