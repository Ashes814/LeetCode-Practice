package AlgVillage.level4;

import java.util.*;

/**
 * @author 欧欧
 * @version 1.0
 */
public class StackLevel {
    public static void main(String[] args) {
//        String test = "(]";
//        System.out.println(isValid(test));
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());
        System.out.println(calculate(" 3 + 11 / 8 + 11  * 32"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item == '(' || item == '[' || item == '{') {
                stringStack.push(item);
            } else {
                if (stringStack.isEmpty()) {
                    return false;
                } else {
                    if (item == ')' && stringStack.pop() == '(') {
                        continue;
                    } else if (item == ']' && stringStack.pop() == '[') {
                        continue;
                    } else if (item == '}' && stringStack.pop() == '{') {
                        continue;
                    } else {
                        return false;
                    }

                }
            }
        }
        if (stringStack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);

                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;





    }
}

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minS;
    public MinStack() {
        stack = new Stack<Integer>();
        minS = new Stack<Integer>();

    }

    public void push(int val) {
        stack.push(val);
        if (minS.isEmpty()) {
            minS.push(val);
        } else if (val < minS.peek()){
            minS.push(val);
        } else {
            minS.push(minS.peek());
        }
    }

    public void pop() {
        stack.pop();
        minS.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
//        Stack<Integer> backupStack = (Stack<Integer>) stack.clone();
//        int minValue = backupStack.pop();
//        while (!backupStack.isEmpty()) {
//            int popValue = backupStack.pop();
//            if (popValue < minValue) {
//                minValue = popValue;
//            }
//        }

        return minS.peek();


    }
}
class MaxStack {
    private Stack<Integer> stack;
    private Stack<Integer> maxS;
    public MaxStack() {
        stack = new Stack<Integer>();
        maxS = new Stack<Integer>();

    }

    public void push(int val) {
        stack.push(val);
        if (maxS.isEmpty()) {
            maxS.push(val);
        } else if (val > maxS.peek()){
            maxS.push(val);
        } else {
            maxS.push(maxS.peek());
        }
    }

    public int pop() {
        maxS.pop();
        return stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {

        return maxS.peek();

    }

    public int popMax() {
        int max = this.peekMax();
        Stack<Integer> buffer = new Stack<>();
        while (this.top() != max) {
            buffer.push(this.pop());
        }
        this.pop();
        while (!buffer.isEmpty()) {
            this.push(buffer.pop());
        }
        return max;


    }
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
