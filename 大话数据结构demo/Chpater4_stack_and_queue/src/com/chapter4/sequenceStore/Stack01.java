package com.chapter4.sequenceStore;

/**
 * @author 欧欧
 * @version 1.0
 */
public class Stack01 {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(5);
        customStack.push(1);
        customStack.push(2);
        customStack.pop();

        customStack.push(3);
        customStack.pop();
        customStack.push(4);
        customStack.push(5);
        customStack.pop();
//        customStack.push(6);

    }
}

class CustomStack {
    public int top = -1;
    public int[] stackArray;
    public int maxSize;

    CustomStack(int stackSize) {
        this.maxSize = stackSize;
        stackArray = new int[stackSize];
    }

    public int push(int stackEle) {
        if (top == maxSize - 1) {
            System.out.println("Stack Full");
            return -1;
        }

        top++;
        stackArray[top] = stackEle;
        System.out.println("Push Success!");
        return 1;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Empty");
            return -1;
        }

        System.out.println(stackArray[top]);
        return stackArray[top];



    }
}