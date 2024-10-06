class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;

        //Binary Search
        long left = 0 , right = x;
        while (left <= right && left != right - 1){
            long mid = (left + right) / 2;
            long mid_Sq = mid * mid;
            if (mid_Sq == x){
                return (int)mid;
            }
            else if (mid_Sq >  x){
                right = mid ;
            }
            else{
                left = mid;
            }
        }
        return (int)left;
    }
}
