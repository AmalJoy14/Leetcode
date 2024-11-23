class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] rotated = new char[n][m];

        for (int i = m - 1 ; i >= 0 ; i--){
            for (int j = 0 ; j < n ; j++){
                rotated[j][m - i - 1] = box[i][j];
            }
        }
        for (int col = 0 ; col < m ; col++){
            int top = n - 1, bottom = n - 1;
            while(top >= 0 && bottom >= 0){
                if (rotated[top][col] == '*'){
                    top--;
                    bottom = top;
                }
                else if (rotated[bottom][col] == '*'){
                    bottom--;
                }
                else if (rotated[bottom][col] == '.' && rotated[top][col] == '#'){
                    rotated[bottom][col] = '#';
                    rotated[top][col] = '.';
                    bottom--;
                    top--;
                }
                else if (rotated[bottom][col] == '#'){
                    bottom--;
                    if (top >= bottom){
                        top = bottom - 1;
                    }
                }
                else if (rotated[top][col] == '.'){
                    top--;
                }
            }
            
        }
        return rotated;
    }
}
