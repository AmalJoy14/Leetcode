class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] rightMax = new int[n];
        int[] leftMax = new int[n];
        rightMax[n - 1] = eventTime - endTime[n - 1];
        int max = rightMax[n - 1];
        for(int i = n - 2 ; i >= 0 ; i--){
            max = Math.max(max , startTime[i + 1] - endTime[i]);
            rightMax[i] = max;
        }
        leftMax[0] = startTime[0];
        max = leftMax[0];
        for(int i = 1 ; i < n ; i ++){
            max = Math.max(max , startTime[i] - endTime[i - 1]);
            leftMax[i] = max;
        }
        //System.out.println(Arrays.toString(leftMax));
        //System.out.println(Arrays.toString(rightMax));

        int res = 0;
        //First box
        if(endTime[0] - startTime[0] <= rightMax[1]){
            res = startTime[1];
        }
        else{
            res = startTime[1] - (endTime[0] - startTime[0]);
        }

        //Last box
        int lastBoxSize = endTime[n - 1] - startTime[n - 1];
        if(lastBoxSize <= leftMax[n - 2]){
            res = Math.max(res , eventTime - endTime[n - 2]);
        }
        else{
            res = Math.max(res , eventTime - endTime[n - 2] - lastBoxSize);
        }
        for(int i = 1 ; i < n - 1 ; i++){
            int size = endTime[i] - startTime[i];
            int space = startTime[i + 1] - endTime[i - 1];
            if(rightMax[i + 1] >= size || leftMax[i - 1] >= size){
                res = Math.max(res , space);
            }
            else{
                res = Math.max(res , space - size);
            }
        }
        return res;
    }
}
