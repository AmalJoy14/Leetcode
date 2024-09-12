class Solution {
    public int findComplement(int num) {
        int n = 0, i = 0;
        while (num != 0 ){
            int rem = num % 2;
            int bit = rem ^ 1;
            // System.out.println(bit);
            if (bit == 1){
                n = n + (int)Math.pow(2,i);
            }
            i++;
            num = num /2;
        }
        return n;
    }
}
