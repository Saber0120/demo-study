package com.structure.array;

/**
 * Created by sheng on 2018/11/14.
 */
public class MyArray {

    private int[] intArray;

    private int elems;

    private int length;

    public MyArray() {
        elems = 0;
        length = 50;
        this.intArray = new int[length];
    }

    public MyArray(int length) {
        elems = 0;
        this.length = length;
        this.intArray = new int[length];
    }

    public int getSize() {
        return elems;
    }

    public void display() {
        for (int i = 0; i < elems; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
    }

    public int get(int i) {
        if (i < 0 || i > elems - 1) {
            System.out.println("下标越界");
        }
        return intArray[i];
    }

    public int find(int searchValue) {
        int i;
        for (i = 0; i < elems; i++) {
            if (intArray[i] == searchValue) {
                break;
            }
        }
        if (i == elems) {
            return -1;
        }
        return i;
    }

    public boolean add(int value) {
        if (elems == length) {
            return false;
        } else {
            intArray[elems] = value;
            elems++;
        }
        return true;
    }

    public boolean delete(int value) {
        int k = find(value);
        if (k == -1) {
            return false;
        } else {
            if (k == elems - 1) {
                elems--;
            } else {
                for (int i = k; i < elems - 1; i++) {
                    intArray[i] = intArray[i+1];
                }
                elems--;
            }
            return true;
        }
    }

    public boolean modify(int oldValue, int newValue) {
        int k = find(oldValue);
        if (k == -1) {
            System.out.println("需要修改的值不存在！");
            return false;
        } else {
            intArray[k] = newValue;
            return true;
        }
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.add(10);
        myArray.add(20);
        myArray.add(30);
        System.out.println(myArray.getSize());
        myArray.display();
        System.out.println(myArray.get(4));
        System.out.println("!!! " + myArray.get(3));
        System.out.println(myArray.find(50));
        System.out.println(myArray.find(30));
        myArray.delete(30);
        System.out.println(myArray.getSize());
        myArray.display();
        myArray.add(60);
        System.out.println(myArray.getSize());
        myArray.display();
        myArray.modify(10,50);
        myArray.display();

    }
}
