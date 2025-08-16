class Solution {
    public int minSensors(int n, int m, int k) {
        int dist = k + k + 1;
        int row = (n / dist);
        if(n > dist * row) row++;
        int col = (m / dist);
        if(m > dist * col) col++;
        return row * col;
    }
}
