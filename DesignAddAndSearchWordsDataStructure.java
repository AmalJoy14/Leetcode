class WordDictionary {
    HashSet<String> set = null;

    public WordDictionary() {
        set = new HashSet<>();    
    }
    
    public void addWord(String word) {
        set.add(word);
    }
    
    public boolean search(String word) {
        int idx1 = -1 , idx2 = -1;
        for(int i = 0 ; i < word.length() ; i++){
            if(word.charAt(i) == '.'){
                if(idx1 == -1){
                    idx1 = i;
                }
                else{
                    idx2 = i;
                }
            }
        }
        if(idx1 == -1 && idx2 == -1){
            return set.contains(word);
        }
        for(char ch = 'a' ; ch <= 'z' ;ch++){
            StringBuilder sb = new StringBuilder(word);
            
            if(idx2 == -1){
                sb.setCharAt(idx1 , ch);
                if(set.contains(String.valueOf(sb))){
                    return true;
                }
            }
            else{
                sb.setCharAt(idx1 , ch);
                for(char ch2 = 'a' ; ch2 <= 'z' ;ch2++){
                    sb.setCharAt(idx2 , ch2);
                    if(set.contains(String.valueOf(sb))){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
