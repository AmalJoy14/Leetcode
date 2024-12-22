class Solution {
    public int maxDistinctElements(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            
            
            int val = binarySearch(k, set, nums[i]);
            if (!set.contains(val)) {
                set.add(val);
                count++;
            }

            // System.out.println(set);
        }
        return count;
    }

    public int binarySearch(int k, HashSet<Integer> set, int num) {

        int left = -k - 1 + num, right = k + num;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (!set.contains(mid)) {
                right = mid;
            } else if (set.contains(mid)) {
                left = mid;
            }
        }
        return right;
    }
}
