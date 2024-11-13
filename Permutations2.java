class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> main = new ArrayList<>();
        for (int e : nums) {
            main.add(e);
        }
        findP(main, new ArrayList<>(), nums.length);
        return list;
    }

    public void findP(List<Integer> main, List<Integer> sub,int size) {
        if (main.size() == 0) {
            list.add(new ArrayList<>(sub));
            return;
        }
        

        for (int i = 0; i < main.size(); i++) {
            while ( i != 0 && main.get(i) == main.get(i - 1)){
                i++;
                if (i == main.size()){
                    return;
                }
            }
            sub.add(main.get(i));
            int val = main.remove(i);
            // System.out.println(main + "  " + sub);
            findP(main, sub , size);
            sub.remove(sub.size() - 1);
            main.add(i, val);
        }

    }
}
