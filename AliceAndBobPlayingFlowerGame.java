class Solution {
    public long flowerGame(int n, int m) {
        long oddN , oddM ,evenN , evenM;
        oddN = n / 2 + n % 2;
        oddM = m / 2 + m % 2;
        evenN = n / 2;
        evenM = m / 2;
        return oddN * evenM + evenN * oddM;
    }
}
