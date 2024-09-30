package AlgBlog.standStack;

import java.util.ArrayList;
import java.util.Arrays;

public class StandStack {
    public static void main(String[] args) {

    }


}


class MyStackArray<T>  {
    private Object[] stack;

    private int top;

    MyStackArray() {
        stack = new Object[10];
    }

    public boolean isEmpty() {
        return top == 0;
    }


    public Object pop() {
        T t = peek();
        if (top > 0) {
            stack[top - 1] = null;
            top--;
        }
        return t;
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

    public void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 3 / 2 + 1;
            stack = Arrays.copyOf(stack, size);
        }
    }
}