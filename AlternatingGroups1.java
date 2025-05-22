class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int res = 0;
        for(int i = 1 ; i <= colors.length ; i++){
            if(colors[i % colors.length] != colors[i - 1] && colors[i % colors.length] != colors[(i + 1) % colors.length]) res++;
        }
        return res;
    }
}
