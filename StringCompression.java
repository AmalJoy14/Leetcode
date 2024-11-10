class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1)
            return 1;
        int count = 1, loc = 0;
        int j = 1,i;
        for (i = 0; j < chars.length; i++) {
            if (chars[i] != chars[j]) {
                chars[loc] = chars[i];
                loc++;
                if (count == 1) {
                    j++;
                    continue;
                }
                String num = String.valueOf(count);
                for (int k = 0; k < num.length(); k++) {
                    chars[loc] = num.charAt(k);
                    loc++;
                }
                count = 1;
            } else {
                count++;
            }
            j++;
        }
        chars[loc] = chars[i];
        loc++;
        if (count != 1) {
            String num = String.valueOf(count);
            for (int k = 0; k < num.length(); k++) {
                chars[loc] = num.charAt(k);
                loc++;
            }
        }
        return loc;
    }
}
