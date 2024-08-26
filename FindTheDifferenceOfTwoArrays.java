class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>();
        HashSet <Integer> set1 = new HashSet<>();
        HashSet <Integer> set2 = new HashSet<>();
        for (int i = 0 ; i < nums1.length ; i++)
            set1.add(nums1[i]);
        for (int i = 0 ; i < nums2.length ; i++)
            set2.add(nums2[i]);

        List<Integer> a = new ArrayList<>();
        for (int i : set1){
            if (!set2.contains(i))
               a.add(i);
        }
        List<Integer> b = new ArrayList<>();
        for (int i : set2){
            if (!set1.contains(i))
               b.add(i);
        }
        list.add(a);
        list.add(b);   
        return list;

    }
}
