class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int a,higherLimit,lowerLimit , size = nums.length;

        for (int i = 0 ; i < nums.length ; i++){
            a = nums[i];
            higherLimit = binarySearchHigh(nums , upper - a);
            lowerLimit = binarySearchLow(nums ,lower - a); 
            // System.out.println(lowerLimit +"  " + higherLimit);
            lowerLimit = Math.max(lowerLimit , i + 1);
            if (higherLimit >= lowerLimit){
                count += higherLimit - lowerLimit + 1;
            }
            
        }
        return count;
    }

    public int binarySearchHigh(int[] nums , int upperlimit){
        int left = 0 , right = nums.length - 1;
        
        while(left < right){
            int mid = (left + right + 1) / 2;
            
            if (nums[mid] <= upperlimit){
                left = mid;
            }
            else{
                right = mid - 1;
            }
        }
        return nums[left] <= upperlimit ? left : left - 1;
    }
    public int binarySearchLow(int[] nums , int lowerlimit){
        
        int left = 0 , right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            
            if (nums[mid] >= lowerlimit){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return nums[left] >= lowerlimit ? left : left + 1;
    }
}
