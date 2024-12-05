class Solution {
    public boolean canAliceWin(int n) {
        int count = 10;
        boolean alice = true;
        while(count >= 1){
            if (alice && count > n) return false;
            if (!alice && count > n) return true;
            n = n - count;
            count--;
            
            alice = !alice;
        }
        return false;
    }
}
