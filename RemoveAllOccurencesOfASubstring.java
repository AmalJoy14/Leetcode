class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while(true){
            int index = sb.indexOf(part);
            if (index == -1) break;
            for (int i = 0 ; i < part.length() ; i++){
                sb.deleteCharAt(index);
            }  
        }
            
        return String.valueOf(sb);
    }
}
