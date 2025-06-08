class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        int[] arr1 = nums.clone();
        //Arrays.copy(nums , arr1);
        int[] arr2 = nums.clone();
        //Arrays.copy(nums , arr2);
        int k1 = k , k2 = k;
        
        
        for(int i = 0 ; i < nums.length - 1 ; i++){
            if(arr1[i] == -1){
                if(k1 > 0 ){
                    arr1[i] = 1;
                    arr1[i + 1] = (int) (arr1[i + 1] * -1);
                    k1--;
                }
            }
        }
        int flag = 0;
        for(int num : arr1){
            if(num == -1) flag = 1;
        }
        if(flag == 0) return true;

        for(int i = 0 ; i < nums.length - 1 ; i++){
            if(arr2[i] == 1){
                if(k2 > 0 ){
                    arr2[i] = -1;
                    arr2[i + 1] = (int) (arr2[i + 1] * -1);
                    k2--;
                }
            }
        }
        flag = 0;
        for(int num : arr2){
            if(num == 1) flag = 1;
        }
        if(flag == 0) return true;
        return false;
    }
}
