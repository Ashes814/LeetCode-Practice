package AlgVillage.Level5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 欧欧
 * @version 1.0
 */
public class HashAndQueue {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_3 = obj.peek();
        int param_2 = obj.pop();

        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_2);
        System.out.println(param_4);
    }
}

class MyQueue {
    Stack<Integer> inputStack = new Stack<>();
    Stack<Integer> outputStack = new Stack<>();
    public MyQueue() {

    }

    public void push(int x) {
        while (!outputStack.isEmpty()) {
            inputStack.push(outputStack.pop());
        }
        inputStack.push(x);
    }

    public int pop() {
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
        return outputStack.pop();

    }

    public int peek() {
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
        return outputStack.peek();

    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();

    }
}
class MyStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());


        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();

    }
}
