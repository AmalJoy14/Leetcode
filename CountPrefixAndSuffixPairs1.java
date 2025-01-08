class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i = 0 ; i < words.length ; i++){
            for(int j = i+1 ; j < words.length ; j++){
                if(isPrefixAndSuffix(words[i] , words[j])){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isPrefixAndSuffix(String a, String b){
        int lenA = a.length(), lenB = b.length();
        
        if(lenA <= lenB){
            if(b.substring(0 , lenA).equals(a) && b.substring(lenB - lenA , lenB).equals(a)){
                return true;
            }
        }
        return false;
    }
}
