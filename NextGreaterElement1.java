class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        for (int i = 0 ; i < nums1.length ; i++){
            int temp = nums1[i];
            nums1[i] = -1;
            int flag = 0;
            for (int j = 0 ; j < nums2.length ; j++){
                if (temp == nums2[j])
                    flag = 1;
                if (flag == 1 && temp < nums2[j]){
                    nums1[i] = nums2[j];
                    break;
                }
                
            }
        }
        return nums1;
    }
}
