class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        int[] count = new int[501];
        for(int i = 0 ; i < n ; i++){
            count[arr[i]]++;
        }
        int res = -1;
        for(int i = 1 ; i < 501 ; i++){
            if(count[i] == i) res = i;
        }
        return res;
    }
}
