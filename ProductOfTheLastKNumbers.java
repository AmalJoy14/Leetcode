class ProductOfNumbers {
    ArrayList<Integer> list = null;
    int adder = 0;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0){
            list.clear();
        }
        else{
            if(list.isEmpty())
                list.add(num);
            else
                list.add(list.get(list.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int n = list.size();
        if(k == n) return list.get(n - 1);
        return k > n ? 0 : list.get(n - 1)/list.get(n - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
