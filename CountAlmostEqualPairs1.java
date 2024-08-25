class Solution {
    public int swapComp(int a, int b){
        List<List<Integer>> list = new ArrayList<>();
        int rem1, rem2,size = 0;
        while (a!= 0 || b != 0 ){
            rem1 = a % 10;
            rem2 = b % 10;
            if (rem1 == rem2){
                a = a / 10;
                b = b /10;
                continue;
            } 
            if (size > 2) return 0;
            if (list.size() <= 2){
                list.add(new ArrayList<>(List.of(rem1,rem2)));
                size++;
            }
            
            a = a / 10;
            b = b /10;
        }
        if (list.size() != 2) return 0;
        if (list.get(0).get(0) == list.get(1).get(1) && list.get(0).get(1) == list.get(1).get(0)){
            return 1;
        }
            
        return 0;
    }
    public int countPairs(int[] nums) {
        int count = 0;
        for (int i = 0 ; i < nums.length - 1 ; i++){
            for (int j = i+1 ; j < nums.length ; j++){
                if (nums[i] == nums[j]){
                    count++;
                    continue;
                } else {
                    count = count + swapComp(nums[i] , nums[j]);
                }
            }
        }
        return count;
    }
}
