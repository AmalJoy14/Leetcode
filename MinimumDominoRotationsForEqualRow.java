class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res1 = -1, res2 = -1;
        for(int i = 0 ; i < 6 ; i++){
            int count1 = 0 , count2 = 0, flag = 0;
            for(int j = 0; j < tops.length ; j++){
                if(tops[j] != i + 1 && bottoms[j] != i + 1){
                    flag = 1;
                    break;
                }
                else if (bottoms[j] != i + 1 && tops[j] == i + 1){
                    count2++;
                }
                else if (tops[j] != i + 1 && bottoms[j] == i + 1){
                    count1++;
                }
            }
            if(flag == 0){
                if(res1 == -1 ) {
                    res1 = count1;
                    res2 = count2;
                }
                
                res1 = Math.min(res1 , count1 );
                res2 =  Math.min(res2 , count2 );
                
            }
        }
        return Math.min(res1 , res2);
    }
}
