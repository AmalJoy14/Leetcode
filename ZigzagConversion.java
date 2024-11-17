class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int incr = numRows + (numRows - 2);
        if (numRows == 1) return s;

        for (int i = 0 ; i < numRows ; i++){
            for (int j = i ; j < s.length() ; j += incr){
                
                sb.append(s.substring(j,j+1));
                if (i != 0 && i != numRows - 1){
                    int index = j + 2*(numRows - i - 1);
                    if (index < s.length())
                        sb.append(s.substring(index , index + 1));
                }
            }
        }

        return String.valueOf(sb);
    }
}
