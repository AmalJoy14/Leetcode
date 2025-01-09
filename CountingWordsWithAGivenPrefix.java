class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for(int i = 0 ; i < words.length ; i++){
            if(pref.length() <= words[i].length() && words[i].substring(0, pref.length()).equals(pref) ){
                count++;
            }
        }
        return count;
    }
}
