class Pair {
    int num;
    int min;

    Pair(int num, int min) {
        this.min = min;
        this.num = num;
    }
}

class MinStack {

    Stack<Pair> s ;

    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        int minSoFar = s.isEmpty() ? val : Math.min(val, s.peek().min);
        s.push(new Pair(val, minSoFar));
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().num;
    }
    
    public int getMin() {
        return s.peek().min;
        
    }
}
