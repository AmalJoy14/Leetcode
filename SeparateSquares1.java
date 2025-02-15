class Solution {
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        
        Arrays.sort(squares , (a , b) -> Integer.compare(a[1] , b[1]));

        double A = 0;
        for(int i = 0 ; i < n ; i++){
            A += (double)squares[i][2] * squares[i][2];
        }
        
        double bottom = 0, top = 2_000_000_000;

        while(top - bottom > 1e-5){
            double mid = (top + bottom) / 2.0;
            
            double halfArea = 0;
            for(int i = 0 ; i < n ; i++){
                if(squares[i][1] >= mid){
                    break;
                }
                if(squares[i][1] + squares[i][2] <= mid){
                    halfArea += (double)squares[i][2] * squares[i][2];
                }
                else {
                    halfArea += (double)(mid - squares[i][1]) * squares[i][2];
                }
            }

            if(halfArea >= A / 2.0){
                top = mid;
            }
            else{
                bottom = mid;
            }
        }
        return top;
    }
}
