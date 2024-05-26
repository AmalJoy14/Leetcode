class Solution {
    public int[] shuffle(int[] nums, int n) {
        int newArr [] =  new int [nums.length];
        int j=0;
        for (int i=0; i<nums.length/2 ; i++){
            newArr[j] = nums[i];
            newArr[j+1] = nums[n];
            j+=2;
            n++;
        }
        return newArr;
    }
}
