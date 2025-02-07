class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] res = new int[queries.length];
        HashMap<Integer , Integer> balls = new HashMap<>();

        int disColor = 0;
        HashMap<Integer,Integer> colorCount = new HashMap<>();
        for(int i = 0 ; i < queries.length ; i++){
            int ball = queries[i][0];
            int color = queries[i][1];
            if(balls.containsKey(ball)){
                int ballColor = balls.get(ball);
                colorCount.put(ballColor , colorCount.get(ballColor) - 1);
                if(colorCount.get(ballColor) == 0){
                    disColor--;
                    colorCount.remove(ballColor);
                }
            }
            if(!colorCount.containsKey(color)){
                colorCount.put(color , 0);
                disColor++;
            }
            colorCount.put(color , colorCount.get(color) + 1);
            balls.put(ball , color);
            res[i] =disColor;
        }
        return res;
    }
}
