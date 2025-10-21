class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int res = 0, n = nums.length , maxi = 1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
            maxi = Math.max(maxi , num);
        }
        Arrays.sort(nums);
        for(int i = 1 ; i <= maxi ; i++){
            int curr = i;
            int left = 0 , right = n - 1;
            //lower end
            int lowerend = 0;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] < curr - k){
                     left = mid + 1;
                }else{
                    lowerend = mid;
                    right = mid - 1;
                }
            }
            int upperend = -1;
            left = 0;
            right = n - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] <= curr + k){
                    upperend = mid;
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            int count = map.getOrDefault(curr , 0);
            //System.out.println(lowerend + " " + upperend);
            if(upperend == -1 || nums[lowerend] > curr + k || nums[upperend] < curr - k){
                res = Math.max(res , count);
            }else{
                int total = upperend - lowerend + 1;
                int extra = total - count;
                res = Math.max(res , Math.min(extra , numOperations) + count);
            }
        }
        return res;
    }
}
