class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int res = 0;
        int size = 1;
        int prev = colors[0];
        int[] colors2 = new int[n*2];
        for(int i = 0 ; i < n ; i++){
            colors2[i] = colors[i];
            colors2[n + i] = colors[i];
        }
        for(int i = 1 ; i < n + k - 1 ; i++){
            if(colors2[i] != prev){
                size++;
                prev = colors2[i];
            }
            else{
                size = 1;
                prev = colors2[i];
            }
            if(size >= k){
                res++;
            }
        }
        return res;
    }
}
