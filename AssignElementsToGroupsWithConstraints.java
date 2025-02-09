class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int[] divisible = new int[100001];
        Arrays.fill(divisible , -1);
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < elements.length ; i++){
            int incr = elements[i];
            if(set.contains(incr)){
                continue;
            }
            for (int val = elements[i] ; val < 100001 ; val += incr){
                if(divisible[val] == -1)
                    divisible[val] = i;
            }
            set.add(incr);
        }
        int[] res = new int[groups.length];
        for(int i = 0 ; i < groups.length ; i++){
            res[i] = divisible[groups[i]];
        }
        return res;
    }
}
