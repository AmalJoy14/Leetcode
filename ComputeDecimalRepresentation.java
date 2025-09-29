class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> list = new ArrayList<>();
        int pos = 1;
        while(n != 0){
            int val = (n % 10) * pos;
            if(val != 0) list.add(val);
            n = n / 10;
            pos *= 10;
        }
        int[] res = new int[list.size()];
        int idx = 0;
        for(int i = list.size() - 1 ; i>= 0 ; i--){
            res[idx++] = list.get(i);
        }
        return res;
    }
}
