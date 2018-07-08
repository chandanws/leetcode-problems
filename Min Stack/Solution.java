// Problem link: https://leetcode.com/problems/min-stack/description/
// Status: Accepted

class MinStack {
    private ArrayList<Integer> l;
    private ArrayList<Integer> sortedL;
    
    /** initialize your data structure here. */
    public MinStack() {
        l = new ArrayList<Integer>();
        sortedL = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        l.add(x);
        sortedL.add(x);
        Collections.sort(sortedL);
    }
    
    public void pop() {
        int numToBeRemoved = top();
        l.remove(l.size() - 1);
        int indexToBeRemoved = Collections.binarySearch(sortedL, numToBeRemoved);
        sortedL.remove(indexToBeRemoved);
    }
    
    public int top() {
        return l.get(l.size() - 1);
    }
    
    public int getMin() {
        return sortedL.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
