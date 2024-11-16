class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length , n = matrix[0].length;
        int i = 0, j = 0, flag = 0;

        while(flag == 0){
            flag = 1;

            //Right
            while(j < n && matrix[i][j] != 404){
                list.add(matrix[i][j]);
                matrix[i][j] = 404;
                flag = 0;
                j++;
            }
            j--;
            i++;

            //Bottom
            while(i < m && matrix[i][j] != 404){
                list.add(matrix[i][j]);
                matrix[i][j] = 404;
                flag = 0;
                i++;
            }
            i--;
            j--;

            // System.out.println(matrix[i][j]);

            //Left
            while(j >= 0 && matrix[i][j] != 404){
                list.add(matrix[i][j]);
                matrix[i][j] = 404;
                flag = 0;
                j--;
            }
            j++;
            i--;

            //Top
            while(i >= 0 && matrix[i][j] != 404){
                list.add(matrix[i][j]);
                matrix[i][j] = 404;
                flag = 0;
                i--;
            }
            i++;
            j++;

        }
        return list;
    }
}
