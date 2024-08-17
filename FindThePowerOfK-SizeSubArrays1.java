class Solution {
    public int[] resultsArray(int[] nums, int k) {
        //SubArrays
        int n = nums.length;
        if (nums.length == 0) return null;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0 ; i<n ; i++){
            ArrayList<Integer> a  = new ArrayList<>();
            for (int j = i ;j<n && j<i+k; j++){
                a.add(nums[j]);
                if (a.size() == k){
                    list.add(a);
                }
            }
        }
       
        int[] res = new int[list.size()];
        for (int i = 0 ; i<list.size() ; i++){
            for (int j = 0 ; j<k ; j++){
                if (k == 1)
                    res[i] = list.get(i).get(0);
                else if (j==0) continue;
                else if (list.get(i).get(j)-1  != list.get(i).get(j-1)) {
                    res[i] = -1;
                    break;
                }
                else{
                    res[i] = list.get(i).get(k-1);
                }
            }
        }
        return res;
    }
}
