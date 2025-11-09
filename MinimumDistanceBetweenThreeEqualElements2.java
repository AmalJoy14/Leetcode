class Solution {
    public int minimumDistance(int[] nums) {
        int res = Integer.MAX_VALUE;
        List<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < nums.length ;i++){
            list.add(new int[]{nums[i] , i});
        }
        Collections.sort(list , (a,b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1] , b[1]);
            else return Integer.compare(a[0] , b[0]);
        });
        for(int i = 1 ; i < nums.length - 1; i++){
            if(list.get(i)[0] == list.get(i - 1)[0] && list.get(i)[0] == list.get(i + 1)[0]){
                int val = Math.abs(list.get(i - 1)[1] - list.get(i)[1]) +
                          Math.abs(list.get(i)[1] - list.get(i + 1)[1]) +
                          Math.abs(list.get(i + 1)[1] - list.get(i - 1)[1]);
                res = Math.min(res , val);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
