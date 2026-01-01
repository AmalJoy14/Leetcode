class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        int[][] arr = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            arr[i][0] = difficulty[i];
            arr[i][1] = profit[i];
        }
        Arrays.sort(arr , (a, b) -> Integer.compare(a[0] , b[0]));
        int max = 0 , res = 0;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max ,arr[i][1]);
            arr[i][2] = max;
        }
        //System.out.println(Arrays.deepToString(arr));
        Arrays.sort(worker);
        int idx = -1;
        for(int i = 0 ; i < worker.length ; i++){
            while(idx < n - 1 && arr[idx + 1][0] <= worker[i]){
                idx++;
            }
            if(idx != -1){
                res += arr[idx][2];
            }
        }
        return res;
    }
}
