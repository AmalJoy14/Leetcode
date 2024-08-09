class Solution {
    public String getEncryptedString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int size = s.length();
        for (int i = 0 ; i < size ; i++){
            sb.append(s.substring((k+i) % size, (k+i) %size+1));
        }
        return String.valueOf(sb);
    }
}
