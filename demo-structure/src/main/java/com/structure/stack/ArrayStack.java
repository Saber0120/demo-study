package com.structure.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by sheng on 2018/11/14.
 */
public class ArrayStack {

    private Object[] elementData;

    private int top;

    private int size;

    public ArrayStack() {
        top = -1;
        size = 10;
        elementData = new Object[size];
    }

    public ArrayStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("栈容量不能小于0");
        }
        top = -1;
        this.size = size;
        this.elementData = new Object[size];
    }

    public Object push(Object item) {
        isGrow(top + 1);
        elementData[++top] = item;
        return item;
    }

    public Object pop() {
        Object obj = peek();
        remove(top);
        return obj;
    }

    public Object peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return elementData[top];
    }

    public void remove(int top) {
        elementData[top] = null;
        this.top--;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isGrow(int minCapacity) {
        int oldCapacity = size;
        if (minCapacity >= oldCapacity) {
            int newCapacity = 0;
            if (((oldCapacity << 1) - Integer.MAX_VALUE) > 0) {
                newCapacity = Integer.MAX_VALUE;
            } else {
                newCapacity = oldCapacity << 1;
            }
            this.size = newCapacity;
            elementData = Arrays.copyOf(elementData, size);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        /*ArrayStack myStack = new ArrayStack(3);
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push("abc");
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());*/

        // 字符串倒序
        /*String str = "how are you";
        ArrayStack arrayStack = new ArrayStack();
        for (char c : str.toCharArray()) {
            arrayStack.push(c);
        }
        while (!arrayStack.isEmpty()) {
            System.out.print(arrayStack.pop());
        }*/

        // 匹配分隔符
        String str = "{12[3<45>6]}";
        String str1 = "{123<45>6]}";
        ArrayStack arrayStack = new ArrayStack();
        for (char c : str.toCharArray()) {
            switch (c) {
                case '{':
                case '[':
                case '<':
                    arrayStack.push(c);
                    break;
                case '}':
                case ']':
                case '>':
                    if (!arrayStack.isEmpty()) {
                        char ch = arrayStack.pop().toString().toCharArray()[0];
                        if (c == '}' && ch != '{' || c == ']' && ch != '[' || c == '>' && ch != '<') {
                            System.out.println("error: " + c + "-" + ch);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
