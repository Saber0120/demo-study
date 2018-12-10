package com.structure.linkedlist;

/**
 * 四、双端链表实现队列
 */
public class QueueLinkedList {

    private DoublePointLinkedList link;

    public QueueLinkedList() {
        link = new DoublePointLinkedList();
    }

    //添加元素
    public void insert(Object obj) {
        link.addTail(obj);
    }

    //移除元素
    public void delete() {
        link.deleteHead();
    }

    public boolean isEmpty() {
        return link.isEmpty();
    }

    public int getSize() {
        return link.getSize();
    }

    public void display() {
        link.display();
    }

    public static void main(String[] args) {
        QueueLinkedList link = new QueueLinkedList();
        link.insert(12);
        link.insert(14);
        link.insert(16);
        link.display();
        link.delete();
        link.display();
    }
}
