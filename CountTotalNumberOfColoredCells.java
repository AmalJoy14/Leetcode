class Solution {
    public long coloredCells(int n) {
        long val = find(0 , 2 , n); 
        return 1 + (n - 1) * 4 +  (val );
    }
    public long find(int k ,int i ,int n){
        // System.out.println(n + " " + i + " " + k);
        if( n < i){
            return 0;
        }
        
        return 4*k + find(k+ 1 , i + 1 , n);
    }
}
