package com.baz.app.facebook.medium;

import com.baz.app.util.TreeNode;

import java.util.Stack;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    /**
     * Convert a BST to a sorted circular doubly-linked list in-place.
     * Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
     * Let's take the following BST as an example, it may help you understand the problem better:
     *
     * We want to transform this BST into a circular doubly linked list.
     * Each node in a doubly linked list has a predecessor and successor.
     * For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
     * The figure below shows the circular doubly linked list for the BST above. The "head" symbol means the node it points to is the smallest element of the linked list.
     *
     * Specifically, we want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. We should return the pointer to the first element of the linked list.
     * The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.
     *
     */

    // in-order traversal O(n) O(n)
    TreeNode prev = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return null;
        TreeNode fake = new TreeNode(0);
        prev = fake;
        // in-order traverse
        inOrderhelper(root);
        //connect head and tail
        prev.right = fake.right;
        fake.right.left = prev;
        return fake.right;
    }

    private void inOrderhelper(TreeNode node){
        if(node == null) return;
        inOrderhelper(node.left);
        // assign prev node's right child to current node
        prev.right = node;
        // assign prev node to current node's left child
        node.left = prev;
        // assign current node to prev pointer
        prev = node;
        inOrderhelper(node.right);
    }

    // O(n) O(n)
    public TreeNode treeToDoublyListIter(TreeNode root){
        // corner case
        if(root == null) return null;

        // use a stack to simulate the call stack in a recursive function
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // use a dummy head to facilitate the convertion
        TreeNode dummy = new TreeNode(0);
        TreeNode prev = dummy;

        while (cur != null || !stack.isEmpty()){
            // still have subtree, go left
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                // cur is null hitting bottom of tree, go back
                TreeNode temp = stack.pop();
                connect(prev, temp);
                prev = temp;
                cur = temp.right;
            }
        }

        TreeNode head = dummy.right;
        connect(prev , head);
        return head;
    }

    private void connect(TreeNode n1, TreeNode n2){
        n1.right = n2;
        n2.left = n1;
    }

    /**
     * Step 1: Divide:
     * We divide tree into three parts: left subtree, root node, right subtree.
     * Convert left subtree into a circular doubly linked list as well as the right subtree.
     * Be careful. You have to make the root node become a circular doubly linked list.
     *
     * Step 2: Conquer:
     * Firstly, connect left circular doubly linked list with the root circular doubly linked list.
     * Secondly, connect them with the right circular doubly linked list. Here we go!
     */




}
