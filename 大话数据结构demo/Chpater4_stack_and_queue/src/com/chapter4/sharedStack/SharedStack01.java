package com.chapter4.sharedStack;

/**
 * @author 欧欧
 * @version 1.0
 */
public class SharedStack01 {
    public static void main(String[] args) {
        SharedStack sharedStack = new SharedStack(5);
        sharedStack.pushS1(1);
        sharedStack.pushS1(2);
        sharedStack.pushS2(3);
        sharedStack.pushS2(4);
        sharedStack.pushS2(5);
        sharedStack.pushS1(6);

        sharedStack.popS1(); // 2
        sharedStack.popS2(); // 5
        sharedStack.pushS1(6); // success
        sharedStack.popS2(); // 4
        sharedStack.popS1(); //6
        sharedStack.popS1(); //1
        sharedStack.popS2(); //3
        sharedStack.popS2(); // Empty

    }
}

class SharedStack {
    public int top1;
    public int top2;
    public int[] stackArray;
    public int maxSize;

    public SharedStack(int stackSize) {
        this.stackArray = new int[stackSize];
        this.maxSize = stackSize;
        top1 = -1;
        top2 = stackSize;
    }

    public void pushS1(int stackEle) {
        if (top1 + 1 == top2) {
            System.out.println("Stack Full S1");
            return;
        }


        stackArray[++top1] = stackEle;
        System.out.println("Push Success S1");
        return;
    }

    public void pushS2(int stackEle) {
        if (top1 + 1 == top2) {
            System.out.println("Stack Full S2");
            return;
        }


        stackArray[--top2] = stackEle;
        System.out.println("Push Success S2");
        return;
    }

    public void popS1() {
        if (top1 == -1) {
            System.out.println("Stack1 Empty");
            return;
        }

        System.out.println(stackArray[top1--]);
        return;
    }

    public void popS2() {
        if (top2 == this.maxSize) {
            System.out.println("Stack2 Empty");
            return;
        }

        System.out.println(stackArray[top2++]);
        return;
    }
}
