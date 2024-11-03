class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        findSubsets(nums, new ArrayList<>(), 0);
        return list;
    }

    public void findSubsets(int[] nums, List<Integer> sub, int idx) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(sub));
            return;
        }

        // Explore without including current element
        findSubsets(nums, sub, idx + 1);

        // Explore including current element
        sub.add(nums[idx]);
        findSubsets(nums, sub, idx + 1);
        sub.remove(sub.size() - 1);
    }
}
