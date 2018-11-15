package com.structure.queue;

/**
 * 双向队列
 * Created by sheng on 2018/11/15.
 */
public class BothWayQue {

    private Object[] bwQue;

    private int maxSize;

    private int front;

    private int rear;

    private int nItems;

    public BothWayQue(int maxSize) {
        this.maxSize = maxSize;
        bwQue = new Object[maxSize];
        front = 0;
        rear = maxSize - 1;
        nItems = 0;
    }

    public void insertLeft(Object value) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        if (front == 0) {
            front = maxSize;
        }
        bwQue[--front] = value;
        nItems++;
    }

    public void insertRight(Object value) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        if (rear == maxSize - 1) {
            rear = -1;
        }
        bwQue[++rear] = value;
        nItems++;
    }

    public Object removeLeft() {
        Object returnValue = null;
        if (isEmpty()) {
            System.out.println("队列为空");
        } else {
            returnValue = bwQue[front];
            bwQue[front] = null;
            front++;
            if (front == maxSize) {
                front = 0;
            }
            nItems--;
        }
        return returnValue;
    }

    public Object removeRight() {
        Object returnValue = null;
        if (isEmpty()) {
            System.out.println("队列为空");
        } else {
            returnValue = bwQue[rear];
            bwQue[rear] = null;
            rear--;
            if (rear == -1) {
                rear = maxSize - 1;
            }
            nItems--;
        }
        return returnValue;
    }

    public Object peekFront() {
        return bwQue[front];
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public int getSize() {
        return nItems;
    }

    public static void main(String[] args) {
        BothWayQue bwQue = new BothWayQue(5);
        bwQue.insertRight(1);
        System.out.println(bwQue.peekFront());
        bwQue.removeLeft();
        System.out.println(bwQue.peekFront());

        bwQue.insertLeft(2);
        System.out.println(bwQue.peekFront());
        bwQue.removeRight();
        System.out.println(bwQue.peekFront());

        bwQue.insertLeft(3);
        System.out.println(bwQue.peekFront());
        bwQue.insertRight(4);
        System.out.println(bwQue.peekFront());
        bwQue.insertLeft(6);
        System.out.println(bwQue.peekFront());
        bwQue.insertLeft(7);
        bwQue.insertLeft(8);
        bwQue.insertLeft(9);
        bwQue.removeRight();
        System.out.println(bwQue.peekFront());
        bwQue.removeLeft();
        System.out.println(bwQue.peekFront());
    }
}
