class Solution {
    public int[] sortByReflection(int[] nums) {
        int[] res = new int[nums.length];
        int[][] arr = new int[nums.length][2];
        for(int i = 0 ; i < nums.length ; i++){
            String s = Integer.toBinaryString(nums[i]);
            int add = 1, num = 0;
            for(int j = 0 ; j < s.length() ; j++){
                if(s.charAt(j) == '1'){
                    num += add;
                }
                add *= 2;
            }
            arr[i][0] = num;
            arr[i][1] = nums[i];
        }
        Arrays.sort(arr , (a, b) -> {
            if(Integer.compare(a[0],b[0]) == 0){
                return Integer.compare(a[1],b[1]);
            }else{
                return Integer.compare(a[0],b[0]);
            }
        });
        //System.out.println(Arrays.deepToString(arr));
        for(int i = 0 ; i < nums.length ; i++){
            res[i] = arr[i][1];
        }
        return res;
    }
}
