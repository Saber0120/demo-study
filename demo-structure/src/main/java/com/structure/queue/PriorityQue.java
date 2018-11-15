package com.structure.queue;

/**
 * 有序队列：按从小到大的顺序取出数据
 * Created by sheng on 2018/11/15.
 */
public class PriorityQue {

    private int[] priQueArray;

    private int maxSize;

    private int nItems;

    public PriorityQue(int maxSize) {
        this.maxSize = maxSize;
        priQueArray = new int[maxSize];
        nItems = 0;
    }

    public void insert(int value) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        if (nItems == 0) {
            priQueArray[nItems] = value;
            nItems++;
        } else {
            int j = nItems - 1;
            // 插入排序法
            while (j >= 0 && value > priQueArray[j]) {
                priQueArray[j+1] = priQueArray[j];
                j--;
            }
            priQueArray[j+1] = value;
            nItems++;
        }
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return -1;
        }
        int k = nItems - 1;
        int returnVlue = priQueArray[k];
        priQueArray[k] = -1;
        nItems--;
        return returnVlue;
    }

    public int peekFront() {
        return priQueArray[nItems-1];
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public static void main(String[] args) {
        PriorityQue priorityQue = new PriorityQue(3);
        priorityQue.insert(15);
        priorityQue.insert(16);
        priorityQue.insert(14);
        System.out.println(priorityQue.peekFront());
        priorityQue.remove();
        System.out.println(priorityQue.peekFront());
        priorityQue.insert(21);
        priorityQue.insert(22);
    }
}
