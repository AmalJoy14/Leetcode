class Solution {
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0 ; i < n ; i++){
            list.add(i);
        }
        int i;
        for(i = k-1 ; list.size() != 1 ; i = (i+k - 1)% list.size()){
            list.remove(i);
        }
        return  list.get(i)+1;
    }
}
