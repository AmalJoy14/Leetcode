class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        HashSet<Integer> set = new HashSet<>();
        int c = 0;
        for (int i = 0 ; i < n ; i++){
            if(digits[i] % 2 != 0) continue;
            for(int j = 0 ; j < n ; j++){
                if(j == i || digits[j] == 0) continue;
                for(int k = 0 ; k < n ; k++){
                    if(k == i || k == j) continue;
                    set.add(digits[j] * 100 + digits[k] * 10 + digits[i]);
                }
            }
        }
        return set.size();
    }
}
