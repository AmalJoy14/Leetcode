class Solution {
    public long minimumSteps(String s) {
        int preZero = 0,preOne = 0;
        if (s.charAt(0) == '1'){
            preOne++;
        }
        else{
            preZero++;
        }
        long moves = 0;
        int len = s.length();
        for (int i = 1 ; i < len ; i++){
            if (s.charAt(i) == '1'){
                preOne++;
            }
            else{
                moves += preOne;
            }
        }
        return moves;
    }
}
