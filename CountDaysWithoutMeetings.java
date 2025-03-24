class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings , (a , b) -> Integer.compare(a[0] , b[0]));
        // System.out.println(Arrays.deepToString(meetings));
        int [] curr = meetings[0];
        int meetdays = 0;
        for(int i = 1 ; i < meetings.length ; i++){
            if(curr[1] >= meetings[i][0]){
                curr[1] = Math.max(meetings[i][1] , curr[1] );
            }
            else{
                meetdays += curr[1] - curr[0] + 1;
                curr = meetings[i];
            }
        }
        meetdays += curr[1] - curr[0] + 1;
        return days - meetdays;
    }
}
