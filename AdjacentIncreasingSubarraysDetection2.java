class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {

        int val1 = 0,val2 = 0;
        int max = 1;
        int j = 1, count1 = 1, count2 = 1, flag = 0;
        
        for (int i = 0; j < nums.size(); i++) {
            if (flag == 0) {
                if (nums.get(j) > nums.get(i)) {
                    count1++;
                } else {
                    val1 = count1;
                    count1 = 1;
                    flag = 1;
                }
            }
            else if (flag == 1){
                if (nums.get(j) > nums.get(i)) {
                    count2++;
                    // System.out.println( " Count 2 " + count2);
                } else {
                    val2 = count2;
                    count2 = 1;
                    flag = 0;
                }  
            }
            max = Math.max(Math.min(val1 , val2), max);
            if (j == nums.size() - 1){
                if (flag == 1){
                    val2 = count2;
                }
                if (flag == 0){
                    val1 = count1;
                }
            }
            // System.out.println(val1 + "  " + val2);
            j++;
            max = Math.max(Math.min(val1 , val2), max);
            max = Math.max(val1 / 2 , max);
            max = Math.max(val2 / 2 , max);
        }
        return max;
    }
}
