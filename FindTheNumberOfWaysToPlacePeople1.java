class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length , count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j || points[j][0] > points[i][0] || points[j][1] < points[i][1]) continue;
                //System.out.println(i + " " + j);
                int flag = 0;
                for(int k = 0 ; k < n ; k++){
                    if(k == i || k == j) continue;
                    if(points[k][0] >= points[j][0] && points[k][0] <= points[i][0] &&
                       points[k][1] <= points[j][1] && points[k][1] >= points[i][1]){
                        flag = 1;
                        break;
                       } 
                }
                if(flag == 0) count++;
            }
        }
        return count;
    }
}
