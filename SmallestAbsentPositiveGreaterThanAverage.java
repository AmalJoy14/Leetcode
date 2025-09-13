class Solution {
    public int smallestAbsent(int[] nums) {
        double sum = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            sum += num;
            set.add(num);
        }
        double avg = sum / (double)nums.length;
        for(int i = 1 ; i <= 101 ; i++){
            if(!set.contains(i) && i > avg){
                return i;
            }
        }
        return -1;
    }
}
