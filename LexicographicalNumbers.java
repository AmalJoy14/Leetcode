class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= 9 ; i++){
            if(i <= n) list.add(i);
            else continue;
            for(int j = 0 ; j <= 9 ; j++){
                int val = (i * 10) + j;
                if(val <= n) list.add(val);
                else continue;
                for(int k = 0 ; k <= 9 ; k++){
                    int val1 = (val * 10) + k;
                    if(val1 <= n) list.add(val1);
                    else continue;
                    for(int l = 0 ; l <= 9 ; l++){
                        int val2 = val1 * 10 + l;
                        if(val2 <= n) list.add(val2);
                        else continue;
                        for(int m = 0 ; m <= 9 ; m++){
                            int val3 = val2 * 10 + m;
                            if(val3 <= n) list.add(val3);
                        }
                    }
                }
            }
        }
        return list;
    }
}
