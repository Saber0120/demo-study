package com.structure.tree;

/**
 * 二叉树的链式存储
 * https://blog.csdn.net/wuwenxiang91322/article/details/12231657
 */
public class BinaryTree {

    private TreeNode root = null;

    public BinaryTree() {
        this.root = new TreeNode(1, "rootNode(A)");
    }

    /**
     * 创建一棵二叉树
     * <pre>
     *           A
     *     B          C
     *  D     E            F
     *  </pre>
     * @param root
     * @author WWX
     */
    public void createBinTree(TreeNode root) {
        TreeNode newNodeB = new TreeNode(2, "B");
        TreeNode newNodeC = new TreeNode(3, "C");
        TreeNode newNodeD = new TreeNode(4, "D");
        TreeNode newNodeE = new TreeNode(5, "E");
        TreeNode newNodeF = new TreeNode(6, "F");
        TreeNode newNodeG = new TreeNode(7, "G");
        root.leftChild = newNodeB;
        root.rightChild = newNodeC;
        root.leftChild.leftChild = newNodeD;
        root.leftChild.rightChild = newNodeE;
        root.rightChild.rightChild = newNodeF;
        root.leftChild.rightChild.rightChild = newNodeG;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 树的高度
     * @return
     */
    public int height() {
        return height(root);
    }

    /**
     * 节点数
     * @return
     */
    public int size() {
        return size(root);
    }

    private int height(TreeNode subTree) {
        if (subTree == null) {
            return 0;
        } else {
            int i = height(subTree.leftChild);
            int j = height(subTree.rightChild);
            return (i < j) ? (j + 1) : (i + 1);
        }
    }

    private int size(TreeNode subTree) {
        if (subTree == null) {
            return 0;
        } else {
            return 1 + size(subTree.leftChild) + size(subTree.rightChild);
        }
    }

    /**
     * 查找双亲节点
     * @param element
     * @return
     */
    public TreeNode parent(TreeNode element) {
        return (root == null || element == root) ? null : parent(root, element);
    }

    public TreeNode parent(TreeNode subTree, TreeNode element) {
        if (subTree == null) {
            return null;
        }
        if (element.equals(subTree.leftChild) || element.equals(subTree.rightChild)) {
            return subTree;
        }
        TreeNode p;
        if ((p = parent(subTree.leftChild, element)) != null) {
            return p;
        } else {
            return parent(subTree.rightChild, element);
        }
    }

    public TreeNode getLeftTreeNode(TreeNode element) {
        return element != null ? element.leftChild : null;
    }

    public TreeNode getRightTreeNode(TreeNode element) {
        return element != null ? element.rightChild : null;
    }

    public TreeNode getRoot() {
        return root;
    }

    /**
     * 释放节点时应将其子树都释放
     * @param subTree
     */
    public TreeNode destroy(TreeNode subTree) {
        if (subTree != null) {
            subTree.leftChild = destroy(subTree.leftChild);
            subTree.rightChild = destroy(subTree.rightChild);
        }
        return null;
    }

    public void traverse(TreeNode subTree) {
        if (subTree != null) {
            System.out.println("key : " + subTree.key + " , data : " + subTree.data);
            traverse(subTree.leftChild);
            traverse(subTree.rightChild);
        }
    }

    /**
     * 前序遍历
     * @param subTree
     */
    public void preOrder(TreeNode subTree) {
        if (subTree != null) {
            visited(subTree);
            preOrder(subTree.leftChild);
            preOrder(subTree.rightChild);
        }
    }

    /**
     * 中序遍历
     * @param subTree
     */
    public void inOrder(TreeNode subTree) {
        if (subTree != null) {
            inOrder(subTree.leftChild);
            visited(subTree);
            inOrder(subTree.rightChild);
        }
    }

    /**
     * 后序遍历
     * @param subTree
     */
    public void postOrder(TreeNode subTree) {
        if (subTree != null) {
            postOrder(subTree.leftChild);
            postOrder(subTree.rightChild);
            visited(subTree);
        }
    }

    private void visited(TreeNode element) {
        element.isVisited = true;
        System.out.println("key : " + element.key + " , data : " + element.data);
    }

    class TreeNode {
        private int key = 0;//层级
        private String data = null;//数据
        private boolean isVisited = false;
        private TreeNode leftChild = null;
        private TreeNode rightChild = null;

        public TreeNode() {
        }

        public TreeNode(int key, String data) {
            this.key = key;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinTree(bt.root);

        System.out.println("size : " + bt.size());
        System.out.println("height : " + bt.height());

        System.out.println("前序遍历结果 ：");
        bt.preOrder(bt.root);

        System.out.println("中序遍历结果 ：");
        bt.inOrder(bt.root);

        System.out.println("后序遍历结果 ：");
        bt.postOrder(bt.root);

        System.out.println("traverse : ");
        bt.traverse(bt.root);
    }
}
