package com.chapter4.linkedStore;

/**
 * @author 欧欧
 * @version 1.0
 */
public class StackLinkStore01 {
    public static void main(String[] args) {
        LinkedStack<Integer> integerLinkedStack = new LinkedStack<>();
        integerLinkedStack.push(1);

        integerLinkedStack.push(2);
        integerLinkedStack.pop();
        integerLinkedStack.pop();
        integerLinkedStack.pop();

    }
}

class LinkedStack<T> {
    public Node<T> top;
    private int size;
    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void push(T stackEle) {

        Node<T> eleNode = new Node(stackEle);
        eleNode.next = top;
        top = eleNode;
        this.size++;
        System.out.println("push Success");

    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack Empty");
            return;
        }


        System.out.println("pop success" + top.data);
        top = top.next;
    }

}

