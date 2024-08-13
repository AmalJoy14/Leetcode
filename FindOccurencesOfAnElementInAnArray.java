class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int size = queries.length;
        int[] res = new int[size];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0 ; i< nums.length ; i++){
            if (nums[i] == x){
                list.add(i);
            }
        }
        int k = 0;
        for (int i = 0 ; i< size ; i++){
            if (queries[i] > list.size()){
                res[k] = -1;
                k++;
                continue;
            }
            res[k] = list.get(queries[i] - 1);
            k++;
        }
        return res;
    }
}
