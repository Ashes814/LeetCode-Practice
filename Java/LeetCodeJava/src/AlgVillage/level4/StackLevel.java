package AlgVillage.level4;

import java.util.Arrays;

/**
 * @author 欧欧
 * @version 1.0
 */
public class StackLevel {
}

class MyStack<T> {
    private Object[] stack;
    private int top;

    MyStack() {
        stack = new Object[10];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public T peek() {
        T t = null;
        if (top > 0) {
            t = (T) stack[top - 1];

        }
        return t;
    }

    public void push(T t) {
        expandCapacity(top + 1);
        stack[top] = t;
        top++;
    }

    public T pop() {
        T t = peek();
        if (top > 0) {
            stack[top - 1] = null;
            top--;
        }
        return t;
    }

    public void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 3 / 2 + 1;
            stack = Arrays.copyOf(stack, size);
        }
    }
}
