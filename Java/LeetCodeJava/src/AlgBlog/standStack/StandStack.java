package AlgBlog.standStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StandStack {
    public static void main(String[] args) {
//        System.out.println(isValid(""));
//        System.out.println(calculate(" 3+5 / 2 "));
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
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

    public static int calculate(String s) {
        s = s.replaceAll(" ", "");
        Stack<String> tempStack = new Stack<>();
        String[] sArray = s.split("(?=[-+*/])|(?<=[-+*/])");
        for (int i = 0; i < sArray.length; i++) {
            int num;
            int res;
            String c = sArray[i];
            if (c.equals("+") || c.equals("-")) {
                tempStack.push(c);
            } else if (c.equals("*")) {
                num = Integer.parseInt(tempStack.pop());
                res = num * Integer.parseInt(sArray[++i]);
                tempStack.push(String.valueOf(res));
            }  else if (c.equals("/")) {
                num = Integer.parseInt(tempStack.pop());
                res = num / Integer.parseInt(sArray[++i]);
                tempStack.push(String.valueOf(res));
            } else {
                tempStack.push(c);
            }

        }

        Stack<String> tempStack2 = new Stack<>();
        while (!tempStack.isEmpty()) {
            tempStack2.push(tempStack.pop());
        }

        int finRes = Integer.parseInt(tempStack2.pop());
        while (!tempStack2.isEmpty()) {
            String symbol = tempStack2.pop();
            int num2 = Integer.parseInt(tempStack2.pop());
            if (symbol.equals("+")) {
                finRes = finRes + num2;
            } else {
                finRes = finRes - num2;
            }

        }
        return finRes;

    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num1;
        int num2;
        for (String t: tokens) {
            if (t.equals("+")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num1 + num2);
            } else if (t.equals("-")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 - num1);

            } else if (t.equals("*")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 * num1);
            } else if (t.equals("/")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(t));
            }

        }

        return stack.pop();
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