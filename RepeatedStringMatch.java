class Solution {
    public int repeatedStringMatch(String a, String b) {
        if(a.contains(b)) return 1;
        int mul = b.length() / a.length();
        String s = a.repeat(mul);
        if(s.contains(b)) return mul;
        s = a.repeat(mul + 1);
        if(s.contains(b)) return mul + 1;
        s = a.repeat(mul + 2);
        if(s.contains(b)) return mul + 2;
        return -1;
    }
}
