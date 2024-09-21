class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;
        int mostElemCount = 0;
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
                mostElemCount = Math.max(mostElemCount, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
                mostElemCount = Math.max(mostElemCount, map.get(ch));
            }
            int size = right - left + 1;
            if (size - mostElemCount > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
                size--;
            }
            max = Math.max(size, max);
        }
        return max;
    }
}
