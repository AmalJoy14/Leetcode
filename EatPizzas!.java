class Solution {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        int n = pizzas.length;
        int m = n / 4;
        int odd = m / 2 + m % 2;
        int even = m / 2;
        long res = 0;
        for(int i = 0 ; i < odd ; i++){
            res += pizzas[n - i - 1];
        }
        for(int i = 1 ; i < even * 2 ; i+= 2){
            res += pizzas[n - i - 1 - odd];
        }
        return res;
    }
}
