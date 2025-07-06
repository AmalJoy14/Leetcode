class FindSumPairs {
    HashMap<Integer , Integer> map = null;
    ArrayList<Integer> list  = null;
    ArrayList<Integer> list2 = null;

    public FindSumPairs(int[] nums1, int[] nums2) {
        map = new HashMap<>();
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        for(int num : nums1){
            list.add(num);
        }
        for(int i = 0 ; i < nums2.length ; i++){
            list2.add(nums2[i]);
            map.put(nums2[i] , map.getOrDefault(nums2[i] , 0) + 1);
        }    
    }
    
    public void add(int index, int val) {
        int num = list2.get(index);
        map.put(num , map.get(num) - 1);
        num += val;
        list2.set(index , num);
        map.put(num , map.getOrDefault(num , 0) + 1);
    }
    
    public int count(int tot) {
        int res = 0;
        for(int i = 0 ; i < list.size() ; i++){
            int val = tot - list.get(i);
            if(map.containsKey(val)){
                res += map.get(val);
            }
        }
        return res;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
