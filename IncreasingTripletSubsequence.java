class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE , second = Integer.MAX_VALUE , third = Integer.MAX_VALUE;
        for(int e : nums){
            if(first >= e){
                first = e;
            }
            else if(second >= e){
                second = e;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
