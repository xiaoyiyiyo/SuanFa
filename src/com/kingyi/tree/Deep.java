package com.kingyi.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiaoyiyiyo on 2018/5/13.
 */
public class Deep {

    // 递归算法
    public static int getDeep(TreeNode root) {

        int deep = 0;
        if (root != null) {
            int ldeep = getDeep(root.leftNode);
            int rdeep = getDeep(root.rightNode);
            deep = ldeep > rdeep ? ldeep + 1 : rdeep + 1;
        }
        return deep;
    }

    //非递归
    public static int getDeep2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode currentNode = null;
        int cur, last;
        int deep = 0;
        while (!queue.isEmpty()) {
            cur = 0;
            last = queue.size();
            while (cur < last) {
                currentNode = queue.poll();
                cur ++;

                if (currentNode.leftNode != null) {
                    queue.offer(currentNode.leftNode);
                }

                if (currentNode.rightNode != null) {
                    queue.offer(currentNode.rightNode);
                }
            }
            deep ++;
        }
        return deep;
    }

    public static void main(String args[]){
        TreeNode root = TreeNode.initTree();
        System.out.println(getDeep(root));
        System.out.println(getDeep2(root));
    }
}
