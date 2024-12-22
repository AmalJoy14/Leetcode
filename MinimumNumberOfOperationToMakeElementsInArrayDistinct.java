class Solution {
    public int minimumOperations(int[] nums) {
        int start = 0;
        int count = 0;
        for (int i = start ; i < nums.length ; i++){
            int dis = 1;
            int j ;
            // System.out.println(i + " ");
            HashSet<Integer> set = new HashSet<>();
            set.add(nums[i]);
            for ( j = i + 1 ; j < nums.length ; j++){
                // System.out.println(set);
                if(set.contains(nums[j])){
                    
                    dis = 0;
                    break;
                }
                set.add(nums[j]);
            }
            
            if(dis == 0){
                count++;
                start += 3;
                // System.out.println(start);
            }
            else{
                return count;
            }
            i = start;
            i--;
        }
        // System.out.println("kke");
        // count++;
        return count;
    }
}
