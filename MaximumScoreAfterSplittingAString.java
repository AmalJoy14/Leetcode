class Solution {
    public int maxScore(String s) {
        int one = 0 , zero = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '0'){
                zero++;
            }
            else{
                one++;
            }
        }
        int rightOne = one, leftZero = 0;
        int max;
        if(s.charAt(0) == '0'){
            leftZero++;
        }
        else{
            rightOne--;
        }
        max = rightOne + leftZero;
        for(int i = 1 ; i < s.length() - 1 ; i++){
            if(s.charAt(i) == '0'){
                leftZero++;
            }
            else{
                rightOne--;
            }
            max = Math.max(max , leftZero + rightOne);
        }
        return max;
    }
}
