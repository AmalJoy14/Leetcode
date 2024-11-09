class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombination(new ArrayList<>(), candidates, 0, target);
        return list;
    }

    public void findCombination(List<Integer> arr, int[] candidates, int index, int target) {
        if (target == 0) {
            list.add(new ArrayList<>(arr));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }

        // When the candidate is included.
        arr.add(candidates[index]);
        findCombination(arr, candidates, index + 1, target - candidates[index]);
        arr.remove(arr.size() - 1);


        // When the candidate is excluded.(Remove duplicates)
        while (index < candidates.length - 1 && candidates[index] == candidates[index + 1]) {
            index++;
        }
        findCombination(arr, candidates, index + 1, target);
    }
}
