class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        // If the number of words does not match the pattern length, return false
        if (pattern.length() != words.length) {
            return false;
        }
        
        // Create two hash maps to store the pattern-to-word and word-to-pattern mappings
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();
        
        // Iterate through the pattern and words
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            // Check if the character already has a mapped word
            if (charToWord.containsKey(c)) {
                // If it does, ensure it maps to the current word
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                // If it doesn't have a mapped word, create the mapping
                charToWord.put(c, word);
            }
            
            // Check if the word already has a mapped character
            if (wordToChar.containsKey(word)) {
                // If it does, ensure it maps to the current character
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                // If it doesn't have a mapped character, create the mapping
                wordToChar.put(word, c);
            }
        }
        
        // If all checks pass, the pattern matches the string
        return true;
    }
}
