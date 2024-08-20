class Solution {
    public boolean stoneGame(int[] piles) {
        int left = 0 , right = piles.length - 1;
        int alice = 0, bob = 0;
        while (left < right){
            if (piles[left+1] < piles[right - 1]){
                alice += piles[left];
                left++;
            }
            else if (piles[left+1] >= piles[right - 1]){
                alice += piles[right];
                right--;
            }
        }
        return alice > bob;
    }
}
