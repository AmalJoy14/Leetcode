class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] ch = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int limit = repeatLimit;
        int start = 25;
        for (int i = 25; i >= 0; i--) {
            if (limit == 0 && ch[i] != 0) {

                limit = repeatLimit;
                sb.append((char) (i + (int) 'a'));
                ch[i]--;
                i = 25;
            }

            while (ch[i] != 0 && limit != 0) {
                sb.append((char) (i + (int) 'a'));
                limit--;
                ch[i]--;
                if (ch[i] == 0) {
                    limit = repeatLimit;
                }
            }
        }
        return String.valueOf(sb);
    }
}
