class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0; // Track range of open parentheses
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                low++;   // Minimum required open parentheses increases
                high++;  // Maximum possible open parentheses also increases
            } else if (ch == ')') {
                low = Math.max(low - 1, 0); // Decrease minimum, but ensure it doesn't go below 0
                high--;                    // Decrease maximum
            } else if (ch == '*') {
                low = Math.max(low - 1, 0); // Star can act as ')', reducing minimum
                high++;                    // Star can act as '(', increasing maximum
            }

            if (high < 0) {
                return false; // Too many closing parentheses
            }
        }

        return low == 0; // Valid if no unmatched open parentheses
    }
}
