class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[0] , b[0]));
        List<int[]> list = new ArrayList<>();
        int[] newInterval  = intervals[0];

        for(int i = 1 ; i < intervals.length ; i++){
            if(newInterval[1] < intervals[i][0]){
                list.add(newInterval);
                newInterval = intervals[i];
            }
            else {
                newInterval[1] = Math.max(newInterval[1] , intervals[i][1]);
            }
        }
        list.add(newInterval);
        int[][] res = new int[list.size()][2];
        for(int i = 0 ; i < list.size() ; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
