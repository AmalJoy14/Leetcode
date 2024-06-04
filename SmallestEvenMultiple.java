class Solution {
    public int smallestEvenMultiple(int n) {
        int i;
        for ( i=1 ; i<=1500 ; i++){
            if (i%n==0 && i%2==0){
                return i;
            }
        }
       return i;
    }
}
