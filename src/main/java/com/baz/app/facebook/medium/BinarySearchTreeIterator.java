package com.baz.app.facebook.medium;

import com.baz.app.util.ListNode;
import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeIterator {

    private Stack<TreeNode> stack;

    public BinarySearchTreeIterator(){}

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null){
            stack.push(cur);
            if(cur.left != null)
                cur = cur.left;
            else
                break;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        TreeNode node = cur;
        if(node.right != null){
            node = node.right;
            while (stack != null){
                stack.push(node);
                if(node.left != null)
                    node = node.left;
                else
                    break;
            }
        }
        return cur.val;
    }

    public void test(){
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(3);
        TreeNode r1 = new TreeNode(9);
        TreeNode l1l2 = new TreeNode(2);
        TreeNode l1r2 = new TreeNode(4);
        TreeNode r1l2 = new TreeNode(6);
        TreeNode r1r2 = new TreeNode(10);
        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right = l1r2;
        r1.left = r1l2;
        r1.right = r1r2;

//        Utils.inOrderPrintTree(root);
        BinarySearchTreeIterator binarySearchTreeIterator = new BinarySearchTreeIterator(root);
        while (binarySearchTreeIterator.hasNext()){
            System.out.println(binarySearchTreeIterator.next());
        }
    }
}