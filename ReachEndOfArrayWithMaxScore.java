class Solution {
    public long findMaximumScore(List<Integer> nums) {
        int n = nums.size();
        long res = 0;
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n - 1 ; i++){
            arr[i][0] = nums.get(i);
            arr[i][1] = i;
        }
        int prevIdx = n - 1;
        Arrays.sort(arr , (a, b) -> Integer.compare(b[0] , a[0]));
        for(int i = 0 ; i < n - 1 ; i++){
            if(arr[i][1] > prevIdx) continue;
            res += (prevIdx - arr[i][1]) * (long)arr[i][0];
            prevIdx = arr[i][1];
        }
        return res;
    }
}
