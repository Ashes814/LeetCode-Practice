package AlgBlog.standStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StandStack {
    public static void main(String[] args) {
        System.out.println(isValid(""));
    }

    public static boolean isValid(String s) {
        char[] sArray = s.toCharArray();
        if (sArray.length <= 1) {
            return false;
        }
        Stack<Character> cStack = new Stack<>();
        char curC;
        for (char c: sArray) {
            if (c == '(' || c == '[' || c == '{') {
                cStack.push(c);
            } else {

                if (cStack.isEmpty()) {
                    return false;
                }
                curC = cStack.pop();
                if (!(c == ')' && curC == '(' || c == ']' && curC == '[' || c == '}' && curC == '{')) {
                    return false;
                }
            }



        }

        if (cStack.isEmpty()) {
            return true;
        } else {
         return false;
        }

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