class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1 ; i < n ; i++){
            int j = n - i;
            int num1 = i , num2 = j;
            int flag = 0;
            while(num1 != 0){
                if(num1 % 10 == 0){
                    flag = 1;
                }
                num1 /= 10;
            }
            while(num2 != 0){
                if(num2 % 10 == 0){
                    flag = 1;
                }
                num2 /= 10;
            }
            if(flag == 1) continue;
            return new int[]{i , j};
        }
        return null;
    }
}
