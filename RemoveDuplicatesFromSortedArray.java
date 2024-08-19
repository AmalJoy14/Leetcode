class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        ArrayList <Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int  i = 1 ; i < nums.length ; i++){
            if (nums[i] != nums[i - 1]){
                list.add(nums[i]);
            }
        }
        for (int i = 0 ; i < list.size() ; i++){
            nums[i] = list.get(i);
        }
        return list.size();
    }
}
