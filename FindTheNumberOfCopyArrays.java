class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int[] curr = new int[2];
        curr[0] = bounds[0][0];
        curr[1] = bounds[0][1];
        int n = bounds.length;
        int min = bounds[0][1] - bounds[0][0] + 1;
        for(int i = 1 ; i < n ; i++){
            int diff = original[i] - original[i - 1];
            curr[0] += diff;
            curr[1] += diff;
            if(bounds[i][0] > curr[0]){
                curr[0] = bounds[i][0];
            }
            if(bounds[i][1] < curr[1]){
                curr[1] = bounds[i][1];
            }
            min = Math.min(min , (curr[1] - curr[0]) + 1);
        }
        if(min < 0) return 0;
        return min;
    }
}
