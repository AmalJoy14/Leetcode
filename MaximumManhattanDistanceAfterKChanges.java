class Solution {
    public int maxDistance(String s, int K) {
        int S = 0 , N = 0 , W = 0 , E = 0;
        int x = 0, y = 0 , max = 0;
        for(int i = 0 ; i < s.length() ; i++){
            int k = K;
            char ch = s.charAt(i);
            if(ch == 'N'){
                y++;
                N++;
            }
            else if(ch == 'S'){
                y--;
                S++;
            }
            else if(ch == 'E'){
                x++;
                E++;
            }
            else{
                x--;
                W++;
            }
            int maxh = Math.max(W , E);
            int maxv = Math.max(N , S);
            int minh = Math.min(E, W);
            int minv = Math.min(N , S);
            
            // System.out.print(minv + " " + maxv + " ");
            // System.out.print(minh +" " +  maxh + " ");
            if(minv > k){
                maxv += k;
                minv -= k;
                k = 0;
            }
            else{
                maxv += minv;
                k -= minv;
                minv = 0;
            }
            
            if(minh > k){
                maxh += k;
                minh -= k;
                k = 0;
            }
            else{
                maxh += minh;
                k -= minh;
                minh = 0;
            }
            
            max = Math.max(max , (maxh - minh) + (maxv - minv));
            // System.out.println(max);
        }
        
        return max;
    }
}
