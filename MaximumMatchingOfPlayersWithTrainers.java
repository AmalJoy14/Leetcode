class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length , n = trainers.length;
        int res = 0;
        int i = 0 , j = 0;
        while(i < m && j < n){
            if(players[i] <= trainers[j]){
                res++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return res;
    }
}
