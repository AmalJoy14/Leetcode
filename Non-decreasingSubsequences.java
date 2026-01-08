class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Set<String> set = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        generate(nums , 0 , new ArrayList<>());
        return res;
    }
    public void generate(int[] nums , int i , List<Integer> list){
        if(i == nums.length){
            String str = String.valueOf(list);
            if(list.size() >= 2 && !set.contains(str)){
                set.add(str);
                res.add(new ArrayList<>(list));
            }
            return;
        }
        
        //not take
        generate(nums , i + 1 , list);

        //take
        if(list.size() == 0 || list.get(list.size() - 1) <= nums[i]){
            list.add(nums[i]);
            generate(nums , i + 1 , list);
            list.remove(list.size() - 1);
        }
    }
}
