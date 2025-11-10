class Solution {
    public int minOperations(int[] nums) {
        int prev = -1 , n = nums.length,  prevIdx = n;
        int count = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(n);
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) pairs.add(new int[]{nums[i], i});
            else set.add(i);
        }
        pairs.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int[] arr : pairs){
            if(arr[0] != prev || set.higher(arr[1]) != prevIdx ){
                count++;
                prev = arr[0];
                prevIdx = set.higher(arr[1]);
            }
            set.add(arr[1]);
        }
        return count;
    }
}
