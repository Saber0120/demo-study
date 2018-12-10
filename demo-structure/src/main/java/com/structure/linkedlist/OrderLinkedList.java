package com.structure.linkedlist;

/**
 * 五、抽象数据类型(ADT)：
 * 是指一个数学模型及定义在该模型上的一组操作，是设计工具的理念(比如，我们要存储数据，就从考虑需要在数据上实现的操作开始，需要存取最后一个数据项吗？还是第一个？还是特定值？还是特定位置？)，与接口设计理念是想通的
 * 1、拥有特定特征的数据项
 * 2、在数据上允许的操作
 *
 * 六、有序链表
 * 1、普通的链表插入数据是无序的，在有些应用中需要链表的数据有序，称为有序链表
 * 2、数据按关键值排列
 * 3、优于有序数组的地方是插入速度(因为元素不需要移动)，另外链表可以扩展到全部有效的内存，而数组只能局限于一个固定大小
 *
 * 七、有序链表和无序数组组合排序
 * 1、比如有一个无序数组需要排序，可以用冒泡排序、选择排序、插入排序三种方法，但是其时间级别都是O(N2)
 * 2、使用有序链表进行排序，先将数组元素取出，一个个插入有序链表，然后将他们一个个删除，重新放入数组，就会排好序了
 * 3、效率比使用插入排序要高
 */
public class OrderLinkedList {

    private Node head;

    public OrderLinkedList() {
        head = null;
    }

    //插入数据，并按从小到大顺序排序
    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            return;
        }
        Node previous = null;
        Node current = head;
        while (current != null && current.data < value) {
            previous = current;
            current = current.next;
        }
        previous.next = node;
        node.next = current;
    }

    public void deleteHead() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    public void display() {
        Node current = head;
        if (current != null) {
            System.out.print("[");
            Node node = current;
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

        private int data;

        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        OrderLinkedList link = new OrderLinkedList();
        link.insert(11);
        link.insert(15);
        link.insert(13);
        link.insert(12);
        link.display();
        link.deleteHead();
        link.display();
    }
}
