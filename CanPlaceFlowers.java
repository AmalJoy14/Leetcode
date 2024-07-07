class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean flag = true;
        int count = 0;
        if (flowerbed.length == 1){
            if (flowerbed[0] == 0 && (n ==1 || n==0)){
                return true;
            }
            else if (flowerbed[0] == 1 && n ==0){
                return true;
            }
            return false;
        }
        if ( flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0]=1;
            count++;
        }
        if (flowerbed.length>=3 && flowerbed[flowerbed.length-1] == 0 && flowerbed[flowerbed.length-2] == 0){
            flowerbed[flowerbed.length-1]=1;
            count++;
        }
        for (int i = 1 ;i < flowerbed.length ; i++){
            if (i<flowerbed.length-1 && flowerbed[i] == 0 && flowerbed[i+1]==0 && flowerbed[i-1] == 0){
                flowerbed[i] = 1;
                count++;
            }
        }
        return count>=n;
    }
}
