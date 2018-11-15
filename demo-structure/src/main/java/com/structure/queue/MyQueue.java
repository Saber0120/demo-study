package com.structure.queue;

/**
 * 队列：FIFO 先进先出
 * Created by sheng on 2018/11/15.
 */
public class MyQueue {

    private Object[] queueArray;

    // 队列头位置
    private int front;

    // 队列尾位置
    private int rear;

    private int maxSize;

    // 实际元素数目
    private int nItems;

    public MyQueue(int s) {
        maxSize = s;
        front = 0;
        rear = -1;
        nItems = 0;
        queueArray = new Object[maxSize];
    }

    public void insert(Object value) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        } else {
            if (rear == maxSize - 1) {
                rear = -1;
            }
            queueArray[++rear] = value;
            nItems++;
        }
    }

    public Object remove() {
        Object returnValue = null;
        if (isEmpty()) {
            System.out.println("队列为空");
        } else {
            returnValue = queueArray[front];
            queueArray[front] = null;
            front++;
            if (front == maxSize) {
                front = 0;
            }
            nItems--;
        }
        return returnValue;
    }

    public Object peekFront() {
        return queueArray[front];
    }

    public int getSize() {
        return nItems;
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);
        myQueue.insert(1);
        myQueue.insert(2);
        myQueue.insert(3);
        System.out.println(myQueue.peekFront());
        myQueue.remove();
        System.out.println(myQueue.peekFront());
        myQueue.insert(4);
        myQueue.insert(5);
    }
}
