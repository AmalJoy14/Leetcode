class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxRight = new int[n];
        int max = Integer.MIN_VALUE,maxLeft = Integer.MIN_VALUE;
        for(int i = n - 1 ; i >= 0 ; i--){
            max = Math.max(height[i] , max);
            maxRight[i] = max;
        }
        // System.out.println(Arrays.toString(maxRight));
        int res = 0;
        for(int i = 0 ; i < n ; i++){
            maxLeft = Math.max(maxLeft , height[i]);
            int waterlevel = Math.min(maxLeft , maxRight[i]);
            int water = waterlevel - height[i];
            if(water > 0)
                res += water; 
        }
        return res;
    }
}
