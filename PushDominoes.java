class Solution {
    public String pushDominoes(String dominoes) {
        
        StringBuilder sb = new StringBuilder(dominoes);
        int left = -1 ,right = -1;
        for(int i = 0 ; i < dominoes.length() ; i++){
            char ch = dominoes.charAt(i);
            if(ch == 'L') {
                if(right == -1){
                    int subtemp = i - 1;
                    while(subtemp >= 0 && sb.charAt(subtemp) == '.'){
                        sb.setCharAt(subtemp , 'L');
                        subtemp--;
                    }
                    continue;
                }
                left = i;
                int tempL = left;
                int tempR = right;
                while(left >= 0 && tempL > tempR){
                    
                    if(tempL >= 0 && tempL < dominoes.length()) sb.setCharAt(tempL , 'L');
                    if(tempR >= 0 && tempR < dominoes.length()) sb.setCharAt(tempR , 'R');
                    if(tempL != -1)tempL--;
                    if(tempR != -1)tempR++;
                    
                }
                right = -1;
            }
            else if(ch == 'R'){
                while(right != -1 && right < dominoes.length() && right < i){
                    sb.setCharAt(right , 'R');
                    right++;
                }
                right = i;
            }
        }
        while(right < dominoes.length() && right > left){
            sb.setCharAt(right , 'R');
            right++;
        }
        return String.valueOf(sb);
    }
}
