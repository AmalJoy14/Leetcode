class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {

        int m = rectangles.length;
        
        int[][] h_arr = new int[m][2];
        int[][] v_arr = new int[m][2];
        for(int i = 0 ; i < m ; i++){
            h_arr[i] = new int[]{rectangles[i][0] , rectangles[i][2]};
            v_arr[i] = new int[]{rectangles[i][1] , rectangles[i][3]};
        }

        //horizontal
        Arrays.sort(h_arr , (a , b) -> Integer.compare(a[0] , b[0]));
        int v = 0;
        int[] curr = h_arr[0];
        for(int i = 1 ; i < m ; i++){
            if(curr[1] > h_arr[i][0]){
                curr[1] = Math.max(curr[1] , h_arr[i][1]);
            }
            else{
                v++;
                curr = h_arr[i];
            }
            if(v == 2) return true;
        }

        //vertical
        Arrays.sort(v_arr , (a , b) -> Integer.compare(a[0] , b[0]));
        int h = 0;
        curr = v_arr[0];
        for(int i = 1 ; i < m ; i++){
            if(curr[1] > v_arr[i][0]){
                curr[1] = Math.max(curr[1] , v_arr[i][1]);
            }
            else{
                h++;
                curr = v_arr[i];
            }
            if(h == 2) return true;
        }

        return false;
    }
}
