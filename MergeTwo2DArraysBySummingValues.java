class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0 ;
        int j = 0 ;
        ArrayList<int[]> list = new ArrayList<>();
        int n = nums1.length , m = nums2.length;
        while(i < n && j  < m){
            if(nums1[i][0] == nums2[j][0]){
                list.add(new int[]{nums1[i][0] , nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
            else if(nums1[i][0] < nums2[j][0]){
                list.add(new int[]{nums1[i][0] , nums1[i][1] });
                i++;
            }
            else{
                list.add(new int[]{nums2[j][0] , nums2[j][1]});
                j++;
            }
        }
        while(i < n){
            list.add(new int[]{nums1[i][0] , nums1[i][1] });
            i++;
        }
        while(j < m){
            list.add(new int[]{nums2[j][0] , nums2[j][1]});
            j++;
        }
        int[][] res = new int[list.size()][2];
        for(int k = 0 ; k < list.size() ; k++){
            res[k] = list.get(k);
        }
        return res;
    }
}
