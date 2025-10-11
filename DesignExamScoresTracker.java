class ExamTracker {
    List<long[]> sumArr = null;
    public ExamTracker() {
        sumArr = new ArrayList<>();
    }
    
    public void record(int time, int score) {
        long prevsum = 0;
        if(!sumArr.isEmpty()){
            prevsum = sumArr.get(sumArr.size() - 1)[0];
        }
        sumArr.add(new long[]{score + prevsum, time });
    }
    
    public long totalScore(int startTime, int endTime) {
        int lower = 0 , higher = -1;
        //find lowerend
        int left = 0 , right = sumArr.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(sumArr.get(mid)[1] >= startTime ){
                lower = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        left = 0 ;
        right = sumArr.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(sumArr.get(mid)[1] <= endTime){
                higher = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(higher == -1) return 0;
        long res = sumArr.get(higher)[0];
        if(lower > 0){
            return res - sumArr.get(lower - 1)[0];
        }
        return res;
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */
