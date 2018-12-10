package com.structure.linkedlist;

/**
 * 一、单向链表：
 * 1、只可向一个方向遍历
 * 2、查找时，从第一个节点开始每次访问下一个节点，直到找到元素
 * 3、插入时，只能从表头插入，将当前插入的节点设置为头结点，next指向原头节点
 * 4、删除时，将被删除节点的上一个节点的next指向被删除节点的下一个节点
 */
public class SingleLinkedList {

    private int size;//链表节点的个数

    private Node head;//头节点

    public SingleLinkedList() {
        size = 0;
        head = null;
    }

    private class Node {

        private Object data;//节点的数据

        private Node next;//每个节点的next指向下一个节点

        private Node(Object data) {
            this.data = data;
        }
    }

    //在链表头部添加元素
    public Object addHead(Object obj) {
        Node newHead = new Node(obj);
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }

    //在链表头部删除元素
    public Object deleteHead() {
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查找指定元素，找到返回节点node，找不到返回null
    public Object find(Object obj) {
        Node current = head;
        int tempSize = size;
        while (tempSize > 0) {
            if (obj.equals(current.data)) {
                return current;
            } else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    //删除指定元素，删除成功返回true
    public boolean delete(Object obj) {
        if (size == 0) {
            return false;
        }
        if (obj.equals(head.data)) {
            deleteHead();
            return true;
        }
        if (head.next == null) {
            return false;
        } else {
            Node current = head;
            Node previous = null;
            do {
                if (current.next == null) {
                    return false;
                }
                previous = current;
                current = current.next;
            } while (!obj.equals(current.data));
            previous.next = current.next;
            size--;
            return true;
        }
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

    public static void main (String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        System.out.println("list.isEmpty() : " + list.isEmpty());
        list.addHead(12);
        list.addHead(25);
        list.addHead(40);
        list.addHead(56);
        list.addHead(77);
        System.out.println("list.getSize() : " + list.getSize());
        list.display();
        list.deleteHead();
        list.display();
        list.delete(12);
        list.display();
        list.delete(22);
        list.display();
    }
}
