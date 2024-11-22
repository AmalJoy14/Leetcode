class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        //The solution is simply the frequency of the most common pattern across all rows in the matrix.
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0 ; i < matrix.length ; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0 ; j < matrix[0].length ; j++){
                sb.append(matrix[i][j]);
            }
            String s = String.valueOf(sb);
            map.put( s, map.getOrDefault(s , 0) + 1);

            StringBuilder sb2 = new StringBuilder();
            for (int  k = 0 ; k < sb.length() ; k++){
                if (sb.charAt(k) == '1'){
                    sb2.append('0');
                }
                else{
                    sb2.append('1');
                }
            }
            String s1 = String.valueOf(sb2);
            map.put( s1, map.getOrDefault(s1 , 0) + 1);

        }
        int max = 0;
        for (int ele : map.values()){
            max = Math.max(max , ele);
        }
        return max;
    }
}
