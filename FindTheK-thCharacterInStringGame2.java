class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        int res = 0;
        long size = 1;
        long loc = k;
        int idx = 0;
        while(size < k ){
            size = 2 * size;
            idx++;
        }
        //System.out.println(size);
        while(size != 1){
            idx--;
            if(size / 2 < loc){
                if(operations[idx] == 1){
                    res++;
                }
                loc = loc - size / 2;
            }
            size = size / 2;
        }
        return (char)('a' + ( res % 26 )); 
    }
}
