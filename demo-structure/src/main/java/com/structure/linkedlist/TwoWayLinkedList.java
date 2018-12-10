package com.structure.linkedlist;

/**
 * 八、双向链表
 * 1、可以从两个方向遍历链表
 */
public class TwoWayLinkedList {

    private Node head;

    private Node tail;

    private int size;

    public TwoWayLinkedList() {
        head = tail = null;
        size = 0;
    }

    //在链表头部添加元素
    public void addHead(Object obj) {
        Node node = new Node(obj);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            head.pre = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    //在链表尾部添加元素
    public void addTail(Object obj) {
        Node node = new Node(obj);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.pre = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    //删除头元素
    public Object deleteHead() {
        Node temp = head;
        if (size != 0) {
            head = head.next;
            size--;
            if (size != 0) {
                head.pre = null;
            } else {
                tail = null;
            }
        }
        return temp;
    }

    //删除尾元素
    public Object deleteTail() {
        Node temp = tail;
        if (size != 0) {
            tail = tail.pre;
            size--;
            if (size != 0) {
                tail.next = null;
            } else {
                head = null;
            }
        }
        return temp;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (size > 0) {
            System.out.print("[");
            Node node = head;
            System.out.print(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.print("," + node.data);
            }
            System.out.println("]");
        } else {
            System.out.println("[]");
        }
    }

    private class Node {

        private Object data;

        private Node next;

        private Node pre;//上一个节点

        public Node(Object data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TwoWayLinkedList list = new TwoWayLinkedList();
        System.out.println("list.isEmpty() : " + list.isEmpty());
        list.addHead(12);
        list.addHead(25);
        list.addHead(40);
        list.addTail(56);
        list.addTail(77);
        System.out.println("list.getSize() : " + list.getSize());
        list.display();
        list.deleteHead();
        list.display();
        list.deleteTail();
        list.display();
        list.deleteHead();
        list.deleteHead();
        list.deleteHead();
        list.display();
    }
}
