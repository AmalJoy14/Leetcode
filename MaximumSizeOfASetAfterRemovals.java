class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        int n = nums1.length;
        for(int i = 0 ; i < n ; i++){
            set1.add(nums1[i]);
        }
        for(int i = 0 ; i < n ; i++){
            set2.add(nums2[i]);
        }
        for(int num : set1){
            if(set2.contains(num) && set2.size() > n/ 2){
                set2.remove(num);
            }
        }
        for(int num : set2){
            if(set1.contains(num) && set1.size() > n/ 2){
                set1.remove(num);
            }
        }
        //System.out.println(set1 + " " + set2);
        HashSet<Integer> set = new HashSet<>();
        int k = 0;
        for(int num : set1){
            if(k >= n/2)break;
            set.add(num);
            k++;
        }
        k = 0;
        for(int num : set2){
            if(k >= n/2)break;
            set.add(num);
            k++;
        }
        return set.size();
    }
}
