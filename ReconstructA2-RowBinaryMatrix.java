class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        for(int i = 0 ;i < colsum.length ; i++){
            if(colsum[i] == 2){
                lower--;
                list.get(0).add(1);
                upper--;
                list.get(1).add(1);
            }else if(colsum[i] == 1){
                if(lower > upper){
                    lower--;
                    list.get(1).add(1);
                    list.get(0).add(0);
                }
                else {
                    upper--;
                    list.get(0).add(1);
                    list.get(1).add(0);
                }
            }else{
                list.get(0).add(0);
                list.get(1).add(0);
            }
            if(lower < 0 || upper < 0) return new ArrayList<>();
        }
        if(upper != 0 || lower != 0) return new ArrayList<>();
        return list;
    }
}
