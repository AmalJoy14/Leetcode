class Solution {
    public int minimumRecolors(String blocks, int k) {
        int w = 0 , b = 0;
        int i = 0 , res = Integer.MAX_VALUE;
        for(i = 0 ; i < k ; i++){
            if(blocks.charAt(i) == 'W')
                w++;
            else
                b++;
        }
        res = Math.min(res , w);
        int j = 0;
        i--;
        while(i < blocks.length() - 1){
            // System.out.println(b + " " + w + " " + i + " " + j);
            i++;
            if(blocks.charAt(i) == 'W') w++;
            else b++;
            if(blocks.charAt(j) == 'B') b--;
            else w--;
            j++;
            res = Math.min(res , w);
        }
        return res;
    }
}
