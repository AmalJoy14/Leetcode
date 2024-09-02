class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        int start = 0, end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                end = i - 1;
                if (start == end) {
                    list.add(String.valueOf(nums[start]));
                } else {
                    list.add(nums[start] + "->" + nums[end]);
                }
                start = i;
            }
            end++;
        }
        if (start == end) {
            list.add(String.valueOf(nums[start]));
        } else {
            list.add(nums[start] + "->" + nums[end]);
        }
        return list;
    }
}
