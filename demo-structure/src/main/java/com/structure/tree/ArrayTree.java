package com.structure.tree;

public class ArrayTree<T> {

    private T[] data;

    private int deep;

    private int size = 0;

    private int maxSize;

    public ArrayTree(int deep) {
        this.deep = deep;
        this.maxSize = (int) Math.pow(2, deep) - 1;
        this.data = (T[]) new Object[maxSize];
    }

    public void createRoot(T value) {
        data[0] = value;
        size++;
    }

    /**
     *
     * @param value 新增的值
     * @param index 父节点索引
     * @param left 是否添加到做节点
     */
    public void add(T value, int index, boolean left) {
        if (data[index] == null) {
            throw new RuntimeException(index + " : null");
        }
        if (index * 2 + 1 >= maxSize) {
            throw new RuntimeException(index + " > maxSize : " + maxSize);
        }
        if (left) {
            data[index * 2 + 1] = value;
        } else {
            data[index * 2 + 2] = value;
        }
        size++;
    }

    public boolean isEmpty() {
        return data[0] == null;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < maxSize; i++) {
            str += data[i] + "\t";
        }
        return str;
    }

    public static void main(String[] args) {
        ArrayTree<String> arrayTree = new ArrayTree<>(3);
        arrayTree.createRoot("根节点");
        arrayTree.add("第二层左节点", 0, true);
        arrayTree.add("第二层右节点", 0, false);
        System.out.println(arrayTree.toString());
        arrayTree.add("第三层左节点", 1, true);
        System.out.println(arrayTree.toString());
        arrayTree.add("第三层右节点", 2, false);
        System.out.println(arrayTree.toString());
        System.out.println("二叉树元素个数：" + arrayTree.size());
    }
}
