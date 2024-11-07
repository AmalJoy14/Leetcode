class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        findCombination(new ArrayList<>(), candidates, 0 , 0, target);
        return list;
    }

    public void findCombination(List<Integer> arr, int[] candidates ,int sum , int start, int target){
        if (target == sum){
            list.add(new ArrayList<>(arr));
            return;
        }
        if (target < sum){
            return;
        }
        
        for (int i = start ; i < candidates.length ; i++){
            arr.add(candidates[i]);
            findCombination(arr , candidates, sum + candidates[i], i , target);
            arr.remove(arr.size() - 1);  //backtrack
        }
    }
}
