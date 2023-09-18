package AlgVillage.level4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
    public static int calculate(String inputString) {
        String onlySymbol = inputString.replaceAll("\\d", " ").replaceAll(" ", "");
        String s = inputString.replaceAll(" ", "");
        String[] tokens = s.split("[+\\-*\\/]");
        char[] symbols = onlySymbol.toCharArray();
        List<String> stack = new ArrayList<>();
        Stack<String> stack1 = new Stack<>();

        int left;
        int right;
        char sym;
        String symS;
        int res;
        int i = 0;
        int j = 0;

        boolean isCal = false;
        while (i < tokens.length && j < symbols.length) {
            left = Integer.parseInt(tokens[i]);
            right = Integer.parseInt(tokens[i + 1]);
            sym = symbols[j];
            stack.add(String.valueOf(left));
            stack.add(String.valueOf(sym));
            stack.add(String.valueOf(right));

            if (j + 1 < symbols.length) {
                stack.add(String.valueOf(symbols[j + 1]));
            }

            i += 2;
            j += 2;
        }
        if (i == tokens.length - 1) {
            stack.add(tokens[i]);
        }

        left = Integer.parseInt(stack.get(0));
        for (int k = 0; k < stack.size() - 2;) {
            if (!isCal) {
                left = Integer.parseInt(stack.get(k));
            }

            symS = stack.get(k + 1);
            right = Integer.parseInt(stack.get(k + 2));


            if (symS.equals("*")) {
                res = left * right;
                stack1.push(String.valueOf(res));
                left = res;
                isCal = true;
                k += 2;
            } else if (symS.equals("/")) {
                res = left / right;
                stack1.push(String.valueOf(res));
                left = res;
                isCal = true;
                k += 2;
            } else {
                stack1.push(String.valueOf(left));
                stack1.push(symS);
                k += 2;
                isCal = false;
            }




        }
        if (stack1.peek().equals("+") || stack1.peek().equals("-")) {
            stack1.push(stack.get(stack.size() - 1));
        }
        return 1;






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
