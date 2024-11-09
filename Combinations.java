class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        findCombination( n ,k , new ArrayList<>() , 1);
        return list;
    }

    public void findCombination(int n, int k , List<Integer> sub , int start){
        if (sub.size() == k){
            list.add(new ArrayList<>(sub));
            return;
        }

        for (int i = start ; i <= n ; i++ ){
            sub.add(i);
            findCombination(n , k , sub , i + 1);
            sub.remove(sub.size() - 1);
        }
    }
}
