class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < digits.length ; i++){
            if(digits[i] == 0) continue;
            for(int j = 0 ; j < digits.length ; j++){
                if(j == i) continue;
                for(int k = 0 ; k < digits.length ; k++){
                    if(j != k && k != i && digits[k] % 2 == 0){
                        set.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                    }
                }
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for(int e : set){
            res[i] = e;
            i++;
        }
        Arrays.sort(res);
        return res;
    }
}
