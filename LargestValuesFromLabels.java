class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            arr[i][0] = values[i];
            arr[i][1] = labels[i]; 
        }
        Arrays.sort(arr , (a, b) -> Integer.compare(b[0] , a[0]));
        int idx = 0 , res = 0;
        int[] map = new int[2*10001];
        while(numWanted > 0 && idx < n){
            int val = arr[idx][0];
            int lab = arr[idx][1];
            if(map[lab] < useLimit){
                map[lab]++;
                numWanted--;
                res += val;
            }
            idx++;
        }
        return res;
    }
}
