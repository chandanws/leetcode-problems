// Problem link: https://leetcode.com/problems/implement-queue-using-stacks/description/
// Status: Accepted

class MyQueue {
    private Stack<Integer> pushS;
    private Stack<Integer> popS;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        pushS = new Stack<Integer>();
        popS = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        pushS.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return popS.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(popS.isEmpty()) while(!pushS.isEmpty()) popS.push(pushS.pop());
        return popS.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushS.isEmpty() && popS.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
