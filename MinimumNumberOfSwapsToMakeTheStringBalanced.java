class Solution {
    public int minSwaps(String s) {
        int open = 0, close = 0;

        // Count the imbalance of brackets
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                open++;
            } else {
                if (open > 0) {
                    open--; // This close bracket balances a previous open bracket
                } else {
                    close++; // No matching open bracket, this is an imbalance
                }
            }
        }

        // The number of swaps needed to balance the brackets
        return (close + 1) / 2;
    }
}
