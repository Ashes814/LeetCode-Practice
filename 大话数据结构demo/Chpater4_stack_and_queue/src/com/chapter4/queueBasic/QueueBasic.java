package com.chapter4.queueBasic;

/**
 * @author 欧欧
 * @version 1.0
 */
public class QueueBasic {
    public static void main(String[] args) {
        LoopQueue loopQueue = new LoopQueue(5);
        loopQueue.enQueue(1);
        loopQueue.enQueue(2);
        loopQueue.enQueue(3);
        loopQueue.enQueue(4);
        loopQueue.enQueue(5);

        System.out.println(loopQueue.deQueue());
        System.out.println(loopQueue.deQueue());
        loopQueue.enQueue(6);
        System.out.println(loopQueue.deQueue());
        System.out.println(loopQueue.deQueue());
        System.out.println(loopQueue.deQueue());
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
