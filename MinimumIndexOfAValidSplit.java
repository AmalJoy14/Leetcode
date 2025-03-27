class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int num = -1 , freq = 0;
        for(int i = 0 ; i < n ; i++){
            if(freq == 0 || nums.get(i) == num){
                num = nums.get(i);
                freq++;
            }
            else{
                freq--;
            }
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(num == nums.get(i)){
                count++;
            }
        }
        // System.out.println(num + " " + count);
        int leftC = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums.get(i) == num) leftC++;
            if((i + 1) / 2 < leftC && (count - leftC) > (nums.size() - i - 1) / 2) return i;
        }
        return -1;
    }
}
