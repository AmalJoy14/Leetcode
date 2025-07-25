class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if(oldColor != color)
            paint(image , sr , sc , color , oldColor);
        return image;
    }
    public void paint(int[][] image , int i , int j , int color , int oldColor){
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor){
            return;
        }
        image[i][j] = color;
        //System.out.println(i  + " " + j);
        paint(image , i + 1 , j , color , oldColor);
        paint(image , i - 1 , j , color , oldColor);
        paint(image , i , j + 1 , color , oldColor);
        paint(image , i , j - 1 , color , oldColor);
    }
}
