package AlgBlog.HashQueue;

import java.util.Stack;

public class HashQueueAlg {
}



// Using stack to achieve queue
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;


    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);

    }

    public int pop() {
        if (stack2.isEmpty()) {
            outAndIn();
        }
        return stack2.pop();

    }

    public int peek() {
        if (stack2.isEmpty()) {
            outAndIn();
        }
        return stack2.peek();
    }

    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void outAndIn() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}