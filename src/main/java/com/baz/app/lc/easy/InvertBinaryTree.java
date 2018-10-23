package com.baz.app.lc.easy;

import com.baz.app.Interface.google.Google;
import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree implements Google {

    /**
     * Invert a binary tree.
     *
     * Example:
     * Input:
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     * Output:
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * Trivia:
     * This problem was inspired by this original tweet by Max Howell:
     *
     * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
     */

    // O(n) O(n)
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.right = l;
        root.left = r;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

    // O(n) O(n)
    public TreeNode invertTreeIter(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

    public void invert(TreeNode node){
        if(node == null) return;
        if(node.left!=null) invert(node.left);
        if(node.right!=null) invert(node.right);
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
    }

    public void test(){
        TreeNode root = new TreeNode(0);
        TreeNode r0 = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(5);
        TreeNode r5 = new TreeNode(6);
        TreeNode r6 = new TreeNode(7);
        TreeNode r7 = new TreeNode(8);
        root.left = r0;
        root.right = r1;
        r0.left = r2;
        r0.right =r3;
        r1.left = r4;
        r1.right = r5;
        r2.left = r6;
        r2.right = r7;

        Utils.inOrderPrintTree(root);
        invert(root);
        System.out.println();
        Utils.inOrderPrintTree(root);
    }
}


