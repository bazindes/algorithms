package com.baz.app.template;

import com.baz.app.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversalBTIteratively {

    //use stack to store left child
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }

        return ans;
    }

    //Question : Kth Smallest Element in a BST
    public int kthSmallest(TreeNode root, int k){
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(-- k == 0) break;
            root = root.right;
        }
        return root.val;
    }

    //Question : Validate Binary Search Tree
    public boolean validBST(TreeNode root){
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }

        return true;
    }

}
