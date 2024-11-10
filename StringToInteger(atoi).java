class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        long num = 0;

        int isNegative = 0; // 1 for negative and 2 for positive.
        char ch = s.charAt(0);
        if (ch == '-') {
            isNegative = 1;
        } else if (ch == '+' || (ch >= '0' && ch <= '9')) {
            isNegative = 2;
            if (ch >= '0' && ch <= '9') {
                int digit = ch - '0';
                num = num * 10 + digit;
            }
        }
        if (isNegative == 0) {
            return 0;
        }
        int k = isNegative == 1 ? -1 : 1;
        

        for (int i = 1; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int digit = ch - '0';
                num = num * 10 + k* digit;

                if (num > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (num < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }

        return (int) num;
    }
}
