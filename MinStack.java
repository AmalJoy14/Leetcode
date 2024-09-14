class MinStack {
    ArrayList<Integer> stk = null;
    ArrayList<Integer> minstk = null;
    int top = -1;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stk = new ArrayList<>();
        minstk = new ArrayList<>();
    }
    
    public void push(int val) {      //We have another min-stk to store min val correspoinding to each push. 
        top++;
        stk.add(val);
        if (top == -1){
            min = val;
            
        }
        else if (min > val){
            min = val;
        }
        minstk.add(min);
    }
    
    public void pop() {
        stk.remove(top);
        minstk.remove(top);
        top--;
        if (top == -1){
            min = Integer.MAX_VALUE;
        }
        else{
            min = minstk.get(top);
        }
    }
    
    public int top() {
        return stk.get(top);
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
