class Solution {
    public int[] resultArray(int[] nums) {
        int size = nums.length;
        int[] arr1 = new int[size];
        int[] arr2 = new int[size];
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int k= 1 , j = 1;

        for (int i = 2 ; i < size; i++){
            if(arr1[j-1] > arr2[k-1]){
                arr1[j] = nums[i];
                j++;
            }
            else {
                arr2[k] = nums[i];
                 k++;
            }
        }
        int[] res = new int[size];
        int p = 0;
        int i = 0;
        while (i<arr1.length && arr1[i] != 0){ 
            res[p] = arr1[i];
            p++;
            i++;
        }
        i = 0;
        while (i<arr2.length && arr2[i] != 0){ 
            res[p] = arr2[i];
            p++;
            i++;
        }
        return res;
    }
}
