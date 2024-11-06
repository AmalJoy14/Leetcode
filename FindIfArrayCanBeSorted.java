class Solution {
    public boolean canSortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    if (countSet(nums[j], nums[j - 1])) {
                        int temp = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = temp;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean countSet(int a ,int b){
        int count1 = 0,count2 = 0;
        while(a != 0){
            if (a % 2 == 1){
                count1++;
            }
            a /= 2;
        }
        while(b != 0){
            if (b % 2 == 1){
                count2++;
            }
            b /= 2;
        }
        return count1 == count2;
    }
}
