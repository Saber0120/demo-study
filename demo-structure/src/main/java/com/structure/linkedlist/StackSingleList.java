package com.structure.linkedlist;

/**
 * 二、用单向链表实现栈：
 * 栈的pop和push方法对应在链表头部删除元素deleteHead和在头部增加元素addHead方法
 */
public class StackSingleList {

    private SingleLinkedList link;

    public StackSingleList() {
        this.link = new SingleLinkedList();
    }

    //添加元素
    public void push(Object obj) {
        link.addHead(obj);
    }

    //移除栈顶元素
    public Object pop() {
        return link.deleteHead();
    }

    public int getSize() {
        return link.getSize();
    }

    public boolean isEmpty() {
        return link.isEmpty();
    }

    public void display() {
        link.display();
    }
}
