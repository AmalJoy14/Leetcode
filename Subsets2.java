class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        findSubsets(nums, 0, new ArrayList<>(), nums.length);
        return list;
    }

    public void findSubsets(int[] nums, int index, List<Integer> arr, int size) {
        if (index == size) {
            list.add(new ArrayList<>(arr));
            return;
        }

        //When the element is added.
        arr.add(nums[index]);
        findSubsets(nums, index + 1, arr, size);
        arr.remove(arr.size() - 1);

        //When the element is skipped (Skip the duplicates also)
        while(index < nums.length - 1 && nums[index] == nums[index + 1]){
            index++;
        }
        findSubsets(nums, index + 1, arr, size);
    }
}
