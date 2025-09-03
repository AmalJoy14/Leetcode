class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length , count = 0;
        Arrays.sort(points , (a , b) -> {
            if(Integer.compare(a[1] , b[1]) == 0){
                return Integer.compare(a[0], b[0]);
            }else{
                return Integer.compare(b[1] , a[1]);
            }
        });
        for(int i = 0 ; i < n ; i++){
            int min = Integer.MAX_VALUE;
            for(int j = i + 1 ; j < n ; j++){
                // if(points[j][0] > points[i][0] || points[j][1] < points[i][1]) continue;
                //System.out.println(i + " " + j);
                if(points[j][0] < points[i][0]) continue;
                if(points[j][0] < min) {
                    count++;
                    min = points[j][0];
                }
            }
        }
        return count;
    }
}
