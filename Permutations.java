class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int e : nums){
            arr.add(e);
        }
        findPermutation(0 ,arr, new ArrayList<>() ,nums.length);
        return list;
    }

    public void findPermutation(int index ,List<Integer> arr , List<Integer> res ,int size){
        if (arr.size() == 0){
            list.add(new ArrayList<>(res));
            return;
        }
        for (int i = index ; i < arr.size() ; i++){
            int val = arr.get(0);
            res.add(val);
            arr.remove(0);
            findPermutation(0 ,arr, res ,arr.size());
            arr.add( val);                    //backtrack
            res.remove(res.size() - 1);
        }
    }
}
