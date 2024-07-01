import java.math.BigInteger;
class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder("");
        
        int length = digits.length;
        for (int i = 0; i< length ; i++){
            sb.append(digits[i]);
        }
        BigInteger num = new BigInteger(String.valueOf(sb));
        num = num.add(BigInteger.ONE);
        if ( (String.valueOf(num).length()) > length ){
            length++;
        }
        int[] result = new int[length];
        int i = length - 1;
        while(num.compareTo(new BigInteger("0")) != 0){
            BigInteger rem = BigInteger.ZERO;
            rem = num.remainder(BigInteger.valueOf(10));
            num = num.divide(BigInteger.valueOf(10));
            result[i] = rem.intValue();
            i--;
        }
        return result;
    }
}
