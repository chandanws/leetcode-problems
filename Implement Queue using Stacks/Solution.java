// Problem link: https://leetcode.com/problems/implement-queue-using-stacks/description/
// Status: Accepted

class MyQueue {
    Stack<Integer> pushStack, popStack;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(popStack.isEmpty()) {
            while(!pushStack.isEmpty()) popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(popStack.isEmpty()) {
            while(!pushStack.isEmpty()) popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
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
