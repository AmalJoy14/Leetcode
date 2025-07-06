class Solution {
    public String concatHex36(int n) {
        int square = n * n;
        long cube = square * n;
        String hexStr = Integer.toHexString(square).toUpperCase();
        StringBuilder sb = new StringBuilder();
        while(cube > 0){
            long rem = cube % 36;
            
            if(rem < 10){
                sb.append((char)('0' + rem));
            }
            else{
                sb.append((char)('A' + rem - 10));
            }
            cube /= 36;
        }
        return hexStr + sb.reverse().toString();
    }
}
