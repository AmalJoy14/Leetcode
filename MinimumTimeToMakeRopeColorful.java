class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length() , res = 0;
        for(int i = 0 ; i < n ; i++){
            int max = 0 , sum = 0;
            while(i < n - 1 && colors.charAt(i) == colors.charAt(i + 1)){
                max = Math.max(neededTime[i] , max);
                sum += neededTime[i];
                i++;
            }
            sum += neededTime[i];
            max = Math.max(neededTime[i] , max);
            
            res += sum - max;
        }
        return res;
    }
}
