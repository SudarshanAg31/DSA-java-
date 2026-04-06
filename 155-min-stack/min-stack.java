class MinStack {
    Stack<Integer> st;
    Stack<Integer> st_min;

    public MinStack() {
        st = new Stack<>();
        st_min = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(val);
            st_min.push(val);
        } else if (val > st_min.peek()) {
            st.push(val);
            st_min.push(st_min.peek());
        } else {
            st.push(val);
            st_min.push(val);
        }

    }

    public void pop() {
        st_min.pop();
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return st_min.peek();
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