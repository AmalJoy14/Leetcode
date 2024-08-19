class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        for (int i = 0 ; i< m ; i++){
            nums3[i] = nums1[i];
        }

        int k = 0, i = 0 , j = 0;
        while ( j < m && i < n ){
            if (nums2[i] > nums3[j]){
                nums1[k] = nums3[j];
                k++;
                j++;
            } else {
                nums1[k] = nums2[i];
                k++;
                i++;
            }
        }
        while(i < n){
            nums1[k] = nums2[i];
            k++;
            i++;
        }
        while(j < m){
            nums1[k] = nums3[j];
            k++;
            j++;
        }
    }
}
