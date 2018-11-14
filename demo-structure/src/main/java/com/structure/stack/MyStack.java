package com.structure.stack;

/**
 * Created by sheng on 2018/11/14.
 */
public class MyStack {

    private int[] array;

    private int top;

    private int maxSize;

    public MyStack(int maxSize) {
        this.top = -1;
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            array[++top] = value;
        }
    }

    public int pop() {
        return array[top--];
    }

    public int peek() {
        return array[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(10);
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        System.out.println(myStack.peek());
        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }
}
