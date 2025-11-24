class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();
        long num = 0;
        for(int i = 0 ; i < nums.length ; i++){
            num <<= 1;
            num |= nums[i];
            if(num % 5 == 0) list.add(true);
            else list.add(false);
            num %= 5;
        }
        return list;
    }
}
