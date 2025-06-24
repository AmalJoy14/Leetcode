class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length , start = -1 , end = -1;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == key){
                start = i - k < 0 ? 0 : i - k;
                if(start <= end) start = end + 1;
                end = i + k >= n ? n - 1 : i + k;
                for(int val = start ; val <= end ;val++){
                    list.add(val);
                }
            }
        }
        return list;
    }
}
