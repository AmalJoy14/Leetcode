class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] arr = new int[100];
        int res = 0;
        for(int i = 0 ; i < dominoes.length ; i++){
            int val1 = Math.min(dominoes[i][0], dominoes[i][1]);
            int val2 = Math.max(dominoes[i][0], dominoes[i][1]);
            int val = (int)val1 * 10 + val2;
            res += arr[val];
            arr[val]++;
        }
        return res;
    }
}
