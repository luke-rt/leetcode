class MinStack {
    Stack<Node> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(
            new Node(
                val,
                stack.isEmpty() ? val : Math.min(stack.peek().min, val)
            )
        );
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

class Node {
    public int min;
    public int val;

    public Node(int val, int min) {
        this.val = val;
        this.min = min;
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
