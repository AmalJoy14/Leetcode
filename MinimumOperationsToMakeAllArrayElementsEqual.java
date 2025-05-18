class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefix = new long[n];
        long sum = 0;
        for(int i = 0 ; i < n ;i++){
            sum += nums[i];
            prefix[i] = sum;
        }
        
        
        for(int i = 0 ;i < queries.length ; i++){
            int left = 0 , right = n - 1;
            int pos = -1;
            while(left <= right){
                int mid = (left + right) / 2;
                if(nums[mid] <= queries[i]){
                    pos = mid;
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            long res = 0;
            if(pos == -1){
                list.add(prefix[n - 1] - (long)n * queries[i]); 
                continue;
            }
            //System.out.println(pos);
            res += (long)queries[i] * (pos + 1) - prefix[pos];
            res += (long)prefix[n - 1] - prefix[pos] - (long)queries[i] * (n - pos - 1);
            list.add(res);
        }
        return list;
    }
}
