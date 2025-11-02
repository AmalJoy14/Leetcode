class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 101 , max = 0;
        for(int num : nums){
            set.add(num);
            min = Math.min(num , min);
            max = Math.max(num , max);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = min ; i <= max ; i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}
