class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> start = new ArrayList<>();
        start.add(1);
        list.add(start);

        for(int i = 1 ; i < numRows ; i++){
            ArrayList<Integer> sub = new ArrayList<>();
            sub.add(1);
            for(int j = 1 ; j < i ; j++){
                int val = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
                sub.add(val);
            }
            sub.add(1);
            list.add(sub);
        }
        return list;
    }
}
