package com.structure.linkedlist;

/**
 * 九、双向队列
 * 1、使用双向链表实现双向队列
 */
public class TwoWayQueueLinkedList {

    private TwoWayLinkedList link;

    public TwoWayQueueLinkedList() {
        link = new TwoWayLinkedList();
    }

    public void insertLeft(Object obj) {
        link.addHead(obj);
    }

    public void insertRight(Object obj) {
        link.addTail(obj);
    }

    public Object deleteLeft() {
        return link.deleteHead();
    }

    public Object deleteRight() {
        return link.deleteTail();
    }

    public void display() {
        link.display();
    }

    public static void main(String[] args) {
        TwoWayQueueLinkedList list = new TwoWayQueueLinkedList();
        list.insertLeft(12);
        list.insertLeft(25);
        list.insertLeft(40);
        list.insertRight(56);
        list.insertRight(77);
        list.display();
        list.deleteLeft();
        list.display();
        list.deleteRight();
        list.display();
        list.deleteLeft();
        list.deleteLeft();
        list.deleteRight();
        list.display();
    }
}
