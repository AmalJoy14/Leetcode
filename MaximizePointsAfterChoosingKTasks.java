class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        long res = 0;
        int n = technique1.length;
        int[][] arr = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            arr[i][1] = technique1[i];
            arr[i][2] = technique2[i];
            arr[i][0] = arr[i][1] - arr[i][2];
        }
        Arrays.sort(arr , (a, b) -> Integer.compare(b[0], a[0]));
        for(int i = 0 ; i < n ; i++){
            if(k > 0){
                res += arr[i][1];
                k--;
            }else{
                res += Math.max(arr[i][1] , arr[i][2]);
            }
        }
        return res;
    }
}
