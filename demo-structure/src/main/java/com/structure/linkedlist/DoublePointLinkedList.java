package com.structure.linkedlist;

/**
 * 三、双端链表
 * 1、在设计时，为了方便在尾部添加节点，在链表尾部添加一个节点(不用每次都从头遍历至尾部来找到尾部节点)
 */
public class DoublePointLinkedList {

    private Node head;//头节点

    private Node tail;//尾节点

    private int size;

    public DoublePointLinkedList() {
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
            tail.next = node;
            tail = node;
        }
        size++;
    }

    //在链表头部删除元素
    public boolean deleteHead() {
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
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

        public Node (Object data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        DoublePointLinkedList list = new DoublePointLinkedList();
        System.out.println("list.isEmpty() : " + list.isEmpty());
        list.addHead(12);
        list.deleteHead();
        list.display();
        list.addHead(25);
        list.addHead(40);
        list.addHead(56);
        list.addHead(77);
        System.out.println("list.getSize() : " + list.getSize());
        list.display();
        list.deleteHead();
        list.display();
    }
}
