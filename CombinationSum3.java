class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        findCombinations(0 ,1 , 0 ,k ,n ,new ArrayList<>());
        return list;
    }

    public void findCombinations(int count ,int val,int sum , int k , int n , List<Integer> sub){
        if(count == k && sum == n){
            list.add(new ArrayList<>(sub));
            return;
        }
        if(sum >=  n || count >= k || val > 9){
            return;
        }

        //Include val
        sub.add(val);
        findCombinations(count + 1, val + 1, sum + val, k , n , sub);
        sub.remove(sub.size() - 1);

        //Exclude val
        findCombinations(count , val + 1 , sum , k, n , sub);

    }
}
