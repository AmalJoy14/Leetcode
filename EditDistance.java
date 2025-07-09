class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int[] num : dp){
            Arrays.fill(num , -1);
        }
        return (int)findMin(word1 , word2 , word1.length() - 1 , word2.length() - 1 , dp);
    }

    public long findMin(String w1 , String w2 , int i , int j , int[][] dp){
        if(i < 0 && j < 0){
            return 0;
        }
        if(dp[i + 1][j + 1] != -1){
            return dp[i + 1][j + 1];
        }
        long match = Integer.MAX_VALUE , notmatch = Integer.MAX_VALUE;
        long delete = Integer.MAX_VALUE , replace = Integer.MAX_VALUE , insert = Integer.MAX_VALUE;

        if(i >= 0 &&  j >= 0 && w2.charAt(j) == w1.charAt(i)){
            match = findMin(w1 , w2 , i - 1 , j - 1 , dp);
        }
        else if(i >= 0 || j >= 0){ 
            if(i >= 0 && j >= 0)
                replace = findMin(w1 , w2 , i - 1 , j - 1 , dp) + 1;
            if(i >= 0)
                delete = findMin(w1 , w2 , i - 1 , j  , dp) + 1;
            if(j >= 0)
                insert = findMin(w1 , w2 , i , j - 1 ,dp) + 1;
        }
        
        notmatch = Math.min(delete , Math.min(replace , insert));


        return dp[i + 1][j + 1] = (int)Math.min(match , notmatch);
    }
}
