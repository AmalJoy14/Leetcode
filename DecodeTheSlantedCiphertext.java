class Solution {
    public String decodeCiphertext(String entxt, int rows) {
        int len = entxt.length();
        char[][] mat = new char[rows][len / rows];
        int k = 0;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < len / rows ; j++){
                mat[i][j] = entxt.charAt(k++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0 ; j < len / rows ; j++){
            int p = j;
            for(int i = 0 ; i < rows ; i++){
                if(p >= len / rows) break;
                sb.append(mat[i][p++]);
            }
        }
        int n = sb.length() - 1;
        while(n >= 0 && sb.charAt(n) == ' '){
            sb.deleteCharAt(n);
            n--;
        }
        return String.valueOf(sb); 
    }
}
