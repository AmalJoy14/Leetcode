class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        ArrayList<Integer> gaps = new ArrayList<>();

        int start = 0, end = 0, maxGap = -1 , maxidx = -1;
        for(int i = 0 ; i < startTime.length ; i++){
            end = startTime[i];
            int gap = end - start;
            if(maxGap < gap){
                maxGap = gap; 
                maxidx = i;
            }
            gaps.add(gap);
            start = endTime[i];
        }
        int gap = eventTime - start;
        gaps.add(gap);
        if(maxGap < gap){
            maxGap = gap; 
            maxidx = gaps.size() - 1;
        }
        
        int resMax = 0;
        int sum = 0, idx = 0;
        while( k != -1 && idx < gaps.size()){
            sum += gaps.get(idx);
            idx++;
            k--;
        }
        resMax = sum;
        int left = 0;
        for(int right = idx ; right < gaps.size() ; right++){
            sum += gaps.get(right);
            sum -= gaps.get(left);
            resMax = Math.max(resMax , sum);
            left++;
        }
        // System.out.println(gaps);
        // System.out.println(maxidx);
        return resMax;
    }
}



