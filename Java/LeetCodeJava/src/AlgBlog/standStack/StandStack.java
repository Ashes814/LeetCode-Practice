package AlgBlog.standStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StandStack {
    public static void main(String[] args) {
//        System.out.println(isValid(""));
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());
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

class MinStack {

    int minValue;

    int index = 0;

    ArrayList<Integer> stack;


    ArrayList<Integer> minIndexArray;

    public MinStack() {
        stack = new ArrayList<>();
        minIndexArray = new ArrayList<>(0);
    }

    public void push(int val) {
        stack.add(val);
        if (index != 0) {
            minValue = stack.get(minIndexArray.get(index - 1));
        } else {
            minIndexArray.add(0);
            index++;
            return;
        }

        if (val < minValue) {
            minIndexArray.add(index);
        } else {
            minIndexArray.add(minIndexArray.get(index - 1));
        }

        index++;





    }

    public void pop() {
        if (index > 0) {
            stack.remove(index - 1);
            minIndexArray.remove(index - 1);
            index--;
        }


    }

    public int top() {
        return stack.get(index - 1);
    }

    public int getMin() {
        return stack.get(minIndexArray.get(index - 1));
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