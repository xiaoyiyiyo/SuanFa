package com.kingyi.tree;

/**
 * Created by xiaoyiyiyo on 2018/5/13.
 */
public class TreeNode {

    public int data;

    public TreeNode leftNode;

    public TreeNode rightNode;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode leftNode, TreeNode rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    //                  6
    //            4          9
    //          5          3    7
    //        8    1
    public static TreeNode initTree() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(7);

        TreeNode node3 = new TreeNode(9, node1, node2);

        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(5, node4, node5);
        TreeNode node7 = new TreeNode(4, node6, null);

        TreeNode root = new TreeNode(6, node7, node3);

        return root;
    }
}
