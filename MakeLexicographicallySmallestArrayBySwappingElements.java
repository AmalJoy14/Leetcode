class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] res = nums.clone();

        //Groupism
        Arrays.sort(nums);
        ArrayList<Deque<Integer>> list = new ArrayList<>();
        HashMap<Integer , Integer> map = new HashMap<>();

        int k = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(list.isEmpty() || nums[i] - list.get(k).peekLast() > limit){
                list.add(new ArrayDeque<>());
                k++;
                list.get(k).add(nums[i]);
                map.put(nums[i] , k);
            }
            else if(nums[i] - list.get(k).peekLast() <= limit){
                list.get(k).add(nums[i]);
                map.put(nums[i] , k);
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            res[i] = list.get(map.get(res[i])).removeFirst();
        }
        return res;
    }
}
