package com.chapter4.queueBasic;


/**
 * @author 欧欧
 * @version 1.0
 */
public class QueueBasic {
    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue= new LinkedQueue<>();
        linkedQueue.EnQueue(1);
        linkedQueue.EnQueue(2);
        linkedQueue.EnQueue(3);
        linkedQueue.EnQueue(4);

        System.out.println(linkedQueue.DeQueue());
        System.out.println(linkedQueue.DeQueue());
        System.out.println(linkedQueue.DeQueue());
        System.out.println(linkedQueue.DeQueue());
        linkedQueue.EnQueue(5);
        System.out.println(linkedQueue.DeQueue());
    }
}

class LoopQueue {
    private int queueSize;
    private int[] queueArray;
    private int front;
    private int rear;
    public LoopQueue(int size) {
        this.queueArray = new int[size];
        this.queueSize = size;
    }
    public void enQueue(int ele) {
        // queue Full
        if ((rear + 1) % queueSize == front) {
            System.out.println("Queue Full");
            return;
        }

        if (rear < queueSize - 1) {
            queueArray[rear++] = ele;
            return;
        } else {
            // rear now is in the last
            queueArray[rear] = ele;
            rear = 0;
        }


    }

    public int deQueue() {
        if (front == rear){
            System.out.println("Queue Empty");
            return -1;
        }

        if (front < queueSize - 1) {
            return queueArray[front++];
        } else {
            // front now is in the last
            int value = queueArray[front];
            front = 0;
            return value;
        }

    }

    public void pop() {

    }
}
class LinkedQueue<T> {
    public Node<T> front;
    public Node<T> rear;
    private int size;
    private class Node<T> {
        public T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public LinkedQueue() {
        this.front = this.rear = new Node<T>(null);

    }

    public void EnQueue(T ele) {
        Node<T> eleNode = new Node<T>(ele);
        rear.next = eleNode;
        rear = eleNode;
        size++;
    }

    public T DeQueue() {
        if (front == rear) {
            System.out.println("Queue Empty");
            return null;
        }

        Node<T> valueNode = front.next;
        front.next = valueNode.next;

        if (valueNode == rear) {
            rear = front;
        }
        size--;
        return valueNode.data;
    }
}