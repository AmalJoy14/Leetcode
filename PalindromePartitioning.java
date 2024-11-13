class Solution {
    List<List<String>> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        findPartition(s, new ArrayList<>());
        return list;
    }

    public void findPartition(String s, List<String> sub) {
        if (s.length() == 0) {
            list.add(new ArrayList<>(sub));
            return;
        }
        for (int i = 0; i < s.length(); i++) {

            if (isPalindrome(s.substring(0, i + 1))) {
                sub.add(s.substring(0, i + 1));
                findPartition(s.substring(i + 1, s.length()), sub);
                sub.remove(sub.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
