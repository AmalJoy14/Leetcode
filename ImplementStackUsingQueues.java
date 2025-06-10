class MyStack {
    Queue<Integer> que = null;
    public MyStack() {
        que = new LinkedList<>();
    }
    
    public void push(int x) {
        que.add(x);
    }
    
    public int pop() {
        int size = que.size();
        for(int i = 0 ; i < size - 1 ; i++){
            que.add(que.remove());
        }
        return que.remove();
    }
    
    public int top() {
        int size = que.size();
        for(int i = 0 ; i < size - 1 ; i++){
            que.add(que.remove());
        }
        int ele = que.peek();
        que.add(que.remove());
        return ele;
    }
    
    public boolean empty() {
        return que.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
