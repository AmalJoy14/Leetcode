class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer , Integer> pair1 = new HashMap<>();
        HashMap<Integer , Integer> pair2 = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int c1 = 0 , c2 = 0;
            if(pair1.containsKey(nums[i])){
                c1 = pair1.get(nums[i]);
            }
            if(pair2.containsKey(nums[i])){
                c2 = pair2.get(nums[i]);
            }
            if(c1 <= c2){
                pair1.put(nums[i] , pair1.getOrDefault(nums[i] , 0) + 1);
            }
            else{
                pair2.put(nums[i] , pair2.getOrDefault(nums[i] , 0) + 1);
            }
        }
        return pair1.equals(pair2);
    }
}
