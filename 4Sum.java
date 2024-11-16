class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        // TIME COMPLEXITY :: O(n3)

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        if (n < 4) return list;

        for (int i = 0 ; i < n - 3 ; i++){
            while (i != 0 && i < n - 3 && nums[i] == nums[i - 1]){
                i++;
            }

            for (int j = i + 1 ; j < n - 2 ; j++){
                while (i + 1 != j && j < n - 2 && nums[j] == nums[j - 1]){
                    j++;
                }


                int p = j + 1, q = n - 1;
                while(p < q){
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[p] + (long)nums[q];
                    // System.out.println(sum);
                    if (sum == target){
                        List<Integer> sub = new ArrayList<>();
                        sub.add(nums[i]);
                        sub.add(nums[j]);
                        sub.add(nums[p]);
                        sub.add(nums[q]);
                        list.add(sub);
                        q--;
                        p++;
                        while(p < n - 1 && nums[p] == nums[p - 1])  p++;
                        while(q > j && nums[q] == nums[q + 1])  q--;

                    }
                    else if (sum > target){
                        q--;
                        while(q > j && nums[q] == nums[q + 1])  q--;
                    }
                    else{
                        p++;
                        while(p < n - 1 && nums[p] == nums[p - 1])  p++;
                    }
                    
                }
            }
        }
        return list;
    }
}
