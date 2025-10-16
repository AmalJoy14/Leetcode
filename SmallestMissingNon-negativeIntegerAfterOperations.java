class Solution {
    public int findSmallestInteger(int[] nums, int val) {
        int mex = -1;
        int[] arr = new int[val];
        for(int num : nums){
            if(num < 0) num = val - Math.abs(num) % val;
            arr[num % val]++;
        }
        int i = 0;
        while(true){
            if(arr[i] != 0){
                mex++;
                arr[i]--;
                i++;
            }else{
                break;
            }
            if(i == val) i = 0;
        }
        return mex + 1;
    }
}
